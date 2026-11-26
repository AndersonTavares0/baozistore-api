package br.com.uninter.baozistore;

import br.com.uninter.baozistore.model.Cliente;
import br.com.uninter.baozistore.model.Produto;
import br.com.uninter.baozistore.repository.ClienteRepository;
import br.com.uninter.baozistore.repository.PedidoRepository;
import br.com.uninter.baozistore.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PedidosApiTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @BeforeEach
    void limparBanco() {
        pedidoRepository.deleteAll();
        clienteRepository.deleteAll();
        produtoRepository.deleteAll();
    }

    @Test
    void pedidoValidaReferenciasDisponibilidadeEExclusoes() throws Exception {
        var cliente = new Cliente();
        cliente.setNome("Anderson de Lima Galdino Tavares - RU 5196405");
        cliente.setClienteDesde(LocalDate.of(2026, 11, 23));
        cliente = clienteRepository.save(cliente);

        var produto = new Produto();
        produto.setNome("Baozi de carne suína");
        produto.setPreco(new BigDecimal("8.50"));
        produto.setEstoque(true);
        produto = produtoRepository.save(produto);

        mockMvc.perform(post("/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"clienteId":%d,"produtoId":%d,"quantidade":10}
                                """.formatted(cliente.getId(), produto.getId())))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.clienteId").value(cliente.getId()))
                .andExpect(jsonPath("$.produtoId").value(produto.getId()))
                .andExpect(jsonPath("$.quantidade").value(10));

        var pedidoId = pedidoRepository.findAll().getFirst().getId();
        mockMvc.perform(get("/pedidos/{id}", pedidoId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(pedidoId));

        mockMvc.perform(delete("/clientes/{id}", cliente.getId()))
                .andExpect(status().isConflict());
        mockMvc.perform(delete("/produtos/{id}", produto.getId()))
                .andExpect(status().isConflict());

        mockMvc.perform(post("/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"clienteId":999999,"produtoId":%d,"quantidade":1}
                                """.formatted(produto.getId())))
                .andExpect(status().isNotFound());

        var indisponivel = new Produto();
        indisponivel.setNome("Baozi indisponível");
        indisponivel.setPreco(new BigDecimal("8.50"));
        indisponivel.setEstoque(false);
        indisponivel = produtoRepository.save(indisponivel);
        mockMvc.perform(post("/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"clienteId":%d,"produtoId":%d,"quantidade":1}
                                """.formatted(cliente.getId(), indisponivel.getId())))
                .andExpect(status().isConflict());

        mockMvc.perform(post("/pedidos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                                {"clienteId":%d,"produtoId":%d,"quantidade":0}
                                """.formatted(cliente.getId(), produto.getId())))
                .andExpect(status().isBadRequest());

        mockMvc.perform(delete("/pedidos/{id}", pedidoId))
                .andExpect(status().isNoContent());
        mockMvc.perform(delete("/clientes/{id}", cliente.getId()))
                .andExpect(status().isNoContent());
        mockMvc.perform(delete("/produtos/{id}", produto.getId()))
                .andExpect(status().isNoContent());
    }
}

# Java e estilo

- Java 21, Spring Boot 4.2, Maven (`./mvnw`).
- Pacote raiz `br.com.uninter.baozistore`; regra de negócio com mais de duas decisões fica em `service`.
- Controller: `@RestController` + `@RequestMapping` no plural (`/clientes`), injeção por construtor com `@RequiredArgsConstructor`.
- Repositório: interface vazia estendendo `JpaRepository<Entidade, Long>`.
- Entidade: `@Entity`, `@Id @GeneratedValue(strategy = IDENTITY)`, Lombok `@Getter @Setter`; use relações JPA para chaves estrangeiras.
- DTO de request/response preserva o contrato JSON sem expor proxies JPA.
- Campo monetário: `BigDecimal`. Data: `LocalDate` (ISO `yyyy-MM-dd`).
- Nome de variável e método em português, como o resto do projeto; sem abreviação obscura.
- Comentário só quando explica o porquê; o código já diz o quê.

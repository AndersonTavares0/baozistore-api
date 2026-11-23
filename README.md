# Baozi Store — API REST

API REST para o controle de clientes, produtos e pedidos da Baozi Store (loja de pãozinho chinês).
Trabalho da disciplina **Desenvolvimento Web Back-End** — UNINTER.

**Autor:** Anderson de Lima Galdino Tavares — RU 5196405

## Stack

Java 21 · Spring Boot 4.2 · Spring Data JPA · H2 (MySQL opcional) · Maven

## Como rodar

```bash
./mvnw spring-boot:run
```

A API sobe em `http://localhost:8080` e o console do H2 em `http://localhost:8080/h2-console`
(JDBC URL `jdbc:h2:mem:baozistore`, usuário `sa`, senha vazia).

Para usar MySQL no lugar do H2:

```bash
MYSQL_USER=root MYSQL_PASSWORD=senha ./mvnw spring-boot:run -Dspring-boot.run.profiles=mysql
```

## Endpoints

| Método | Rota | Descrição |
|---|---|---|
| POST | `/clientes` | cria um cliente |
| GET | `/clientes` | lista todos os clientes |
| GET | `/clientes/{id}` | consulta cliente por ID |
| DELETE | `/clientes/{id}` | apaga cliente |
| POST | `/produtos` | cria um produto |
| GET | `/produtos` | lista todos os produtos |
| GET | `/produtos/{id}` | consulta produto por ID |
| DELETE | `/produtos/{id}` | apaga produto |
| POST | `/pedidos` | registra um pedido |
| GET | `/pedidos` | lista todos os pedidos |
| GET | `/pedidos/{id}` | consulta pedido por ID |
| DELETE | `/pedidos/{id}` | apaga pedido |

Respostas: `201` + `Location` no POST, `200` no GET, `204` no DELETE, `404` quando o ID não existe e `400` em corpo inválido.

## Exemplos

```http
POST /clientes
{"nome": "Anderson5196405", "clienteDesde": "2026-11-23"}

201 Created
{"id": 1, "nome": "Anderson5196405", "clienteDesde": "2026-11-23"}
```

```http
POST /produtos
{"nome": "Baozi de carne suína", "preco": 8.50, "estoque": true}
```

```http
POST /pedidos
{"clienteId": 1, "produtoId": 1, "quantidade": 10}
```

## Estrutura

```
src/main/java/br/com/uninter/baozistore/
├── model/       entidades JPA (Cliente, Produto, Pedido)
├── repository/  interfaces Spring Data
└── controller/  endpoints REST
```

A coleção usada nos testes está em `postman/Baozi Store.postman_collection.json`.

## Convenção de commits

[Conventional Commits](https://www.conventionalcommits.org/): `feat:`, `fix:`, `docs:`, `chore:`.

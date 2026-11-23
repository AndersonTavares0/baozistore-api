# Baozi Store — API REST

[![Java 21](https://img.shields.io/badge/Java-21-orange)](https://openjdk.org/projects/jdk/21/)
[![Spring Boot 4.2](https://img.shields.io/badge/Spring%20Boot-4.2-brightgreen)](https://spring.io/projects/spring-boot)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](LICENSE)
[![CI](https://github.com/AndersonTavares0/baozistore-api/actions/workflows/ci.yml/badge.svg)](https://github.com/AndersonTavares0/baozistore-api/actions/workflows/ci.yml)

API REST para o controle de clientes, produtos e pedidos da Baozi Store (loja de pãozinho chinês).
Trabalho da disciplina **Desenvolvimento Web Back-End** — UNINTER.

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

Respostas: `201` + `Location` no POST, `200` no GET, `204` no DELETE, `400` em corpo inválido, `404` para recurso/referência inexistente e `409` quando produto está indisponível ou cliente/produto ainda tem pedido associado.

## Exemplos

```http
POST /clientes
{"nome": "Cliente de demonstração", "clienteDesde": "2026-11-23"}

201 Created
{"id": 1, "nome": "Cliente de demonstração", "clienteDesde": "2026-11-23"}
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
├── controller/  endpoints REST
├── service/     regras de negócio de pedidos
└── dto/         contratos HTTP de pedidos
```

A coleção usada nos testes está em `postman/Baozi Store.postman_collection.json`.

## Convenção de commits

[Conventional Commits](https://www.conventionalcommits.org/): `feat:`, `fix:`, `docs:`, `chore:`.

## Licença

Distribuído sob a licença MIT. Consulte [`LICENSE`](LICENSE).

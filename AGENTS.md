# AGENTS.md

API REST acadêmica da Baozi Store (Java 21, Spring Boot 4.2.0, Spring Data JPA, H2 em memória com perfil opcional `mysql`). Detalhes de rotas e uso para humanos ficam em [`README.md`](README.md).

## Arquitetura e convenções

- Camadas: `model` (entidades JPA com Lombok `@Getter @Setter`), `repository` (Spring Data JPA), `controller` (`@RestController` no plural), `service` (regras de negócio com múltiplas decisões) e `dto` (contratos HTTP desacoplados dos proxies JPA).
- Contratos HTTP: `POST` retorna `201` + `Location`, `DELETE` retorna `204`, ID/referência ausente retorna `404`, regra de negócio violada retorna `409` e corpo inválido retorna `400`.
- Tipos e validação: valide entradas com Jakarta Bean Validation; use `BigDecimal` para valores monetários e `LocalDate` (`yyyy-MM-dd`) para datas.
- Banco em memória: o perfil padrão (`H2`) reinicia os dados e a sequência de IDs a cada startup; use o perfil `mysql` para persistência local.

## Verificação obrigatória

Antes de concluir qualquer alteração ou abrir PR, execute a mesma verificação da CI e confirme todos os testes passando:

```bash
./mvnw --batch-mode --no-transfer-progress verify
```

> Ambiente local: `./mvnw` exige JDK 21 no `JAVA_HOME` (nesta máquina: `~/.local/opt/jdk-21.0.13.1+2`).

## Regras detalhadas (leitura sob demanda)

- Ao criar ou editar código Java, entidades, DTOs, controllers ou testes: leia [`.agents/rules/java.md`](.agents/rules/java.md).
- Ao criar branches, commitar, abrir PR ou alterar arquivos ignorados/pessoais: leia [`.agents/rules/git.md`](.agents/rules/git.md).

# AGENTS.md

API REST da Baozi Store: Java 21 + Spring Boot 4.2 + Spring Data JPA + H2.
Como rodar, rotas e exemplos de JSON estão no `README.md`; aqui fica só o que o código não mostra.

## Estrutura

Pacotes `model`, `repository` e `controller`; regras de negócio ficam em `service`. Contratos HTTP específicos ficam em `dto`.

## Convenções

- Entidades JPA usam Lombok (`@Getter @Setter`); DTOs mantêm o contrato HTTP quando ele difere do mapeamento relacional.
- POST devolve `201` com `Location`, DELETE devolve `204`, ID inexistente devolve `404`.
- Validação Jakarta nos dados recebidos; dinheiro em `BigDecimal`.
- Alterações entram na `main` somente por PR, com CI aprovada.

## Rodar

`./mvnw spring-boot:run` — precisa de JDK 21 no `JAVA_HOME` (nesta máquina: `~/.local/opt/jdk-21.0.13.1+2`).
O H2 é em memória: cada restart zera os dados e reinicia os IDs em 1.

## Regras detalhadas

- Java e estilo: `.agents/rules/java.md`
- Git e PRs: `.agents/rules/git.md`

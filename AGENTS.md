# AGENTS.md

API REST da Baozi Store: Java 21 + Spring Boot 4.2 + Spring Data JPA + H2.
Como rodar, rotas e exemplos de JSON estão no `README.md`; aqui fica só o que o código não mostra.

## Estrutura

Três pacotes: `model`, `repository`, `controller`. Uma regra que passe de duas linhas vira `service`; hoje não existe nenhuma.

## Convenções

- Entidade = classe JPA com Lombok (`@Getter @Setter`), sem DTO enquanto o JSON da entidade for o mesmo do DER.
- POST devolve `201` com `Location`, DELETE devolve `204`, ID inexistente devolve `404`.
- Validação Jakarta nos campos que chegam por POST; dinheiro em `BigDecimal`.
- Commit no padrão Conventional Commits, direto na `main`.

## Rodar

`./mvnw spring-boot:run` — precisa de JDK 21 no `JAVA_HOME` (nesta máquina: `~/.local/opt/jdk-21.0.13.1+2`).
O H2 é em memória: cada restart zera os dados e reinicia os IDs em 1.

## Regras detalhadas

- Java e estilo: `.agents/rules/java.md`
- Git: `.agents/rules/git.md`

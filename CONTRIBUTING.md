# Como contribuir

Este é um projeto acadêmico individual da disciplina **Desenvolvimento Web Back-End** (UNINTER). Sugestões de melhoria e correções podem ser abertas via [issue](https://github.com/AndersonTavares0/baozistore-api/issues); alterações devem explicar o problema, seguir o estilo Java descrito em [`.agents/rules/java.md`](.agents/rules/java.md) e incluir testes de integração quando mudarem comportamento HTTP ou regras de negócio.

## Ambiente e verificação

Pré-requisito: **JDK 21**.

```bash
# Compilar e executar toda a suíte de testes (mesmo comando da CI)
./mvnw --batch-mode --no-transfer-progress verify

# Subir a API localmente em http://localhost:8080
./mvnw spring-boot:run
```

## Fluxo de Pull Request e commits

1. Crie uma branch curta a partir da `main` (`feat/*`, `fix/*`, `docs/*` ou `ci/*`).
2. Use [Conventional Commits](https://www.conventionalcommits.org/), por exemplo `feat: valida quantidade do pedido` ou `docs: atualiza exemplos da API`.
3. Mantenha `target/`, credenciais, `docs/entrega/`, `docs/prints/` e dados pessoais fora do commit.
4. Abra a PR preenchendo o checklist do template e aguarde o check `CI/build` passar antes do Squash merge.

Consulte também o [Código de Conduta](CODE_OF_CONDUCT.md).

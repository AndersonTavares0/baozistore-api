# Git

- Conventional Commits: `feat:`, `fix:`, `docs:`, `chore:`, `test:`, `refactor:`.
- Trunk-based: commit direto na `main`, sem branch por tarefa.
- Um commit por etapa concluída; mensagem no imperativo e em português (`feat: adiciona CRUD de pedidos`).
- `target/`, `.idea/`, `*.iml` e segredos ficam fora do repositório (já cobertos pelo `.gitignore`).
- Credenciais de banco chegam por variável de ambiente (`MYSQL_USER`, `MYSQL_PASSWORD`), nunca no arquivo versionado.
- Tag anotada `v1.0.0` marca a versão entregue.

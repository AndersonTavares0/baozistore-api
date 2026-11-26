# Git e entrega

- Siga Conventional Commits (`feat:`, `fix:`, `docs:`, `chore:`, `test:`, `refactor:`).
- Trabalhe em branches curtas (`feat/*`, `fix/*`, `docs/*`, `ci/*`) e integre alterações na `main` exclusivamente via Pull Request com CI verde, conversas resolvidas e **Squash merge**.
- Use título de PR em Conventional Commits e preencha contexto, alterações e verificação no template de PR.
- Mantenha fora do Git (`target/`, `.idea/`, `.iml`, `docs/entrega/`, `docs/prints/`, credenciais e dados pessoais de teste); credenciais de banco entram apenas via variáveis de ambiente (`MYSQL_USER`, `MYSQL_PASSWORD`).

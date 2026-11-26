# Git

- Conventional Commits: `feat:`, `fix:`, `docs:`, `chore:`, `test:`, `refactor:`.
- GitHub Flow: use branches curtas `feat/*`, `fix/*`, `docs/*` ou `ci/*`; nunca faça commit ou push direto na `main`.
- Abra PR para `main`, aguarde CI verde e conversas resolvidas; integração por Squash.
- Título de PR em Conventional Commits; explique contexto, alteração e testes no template.
- `target/`, `.idea/`, `.iml`, credenciais e dados pessoais de teste ficam fora do repositório.
- Credenciais de banco chegam por variável de ambiente (`MYSQL_USER`, `MYSQL_PASSWORD`), nunca no arquivo versionado.

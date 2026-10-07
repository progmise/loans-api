# AGENTS.md

Guide for working on **loans-api** — progmise Spring Boot microservice for
users and loans. Java 21, Spring Boot 4, Spring Data JPA (PostgreSQL), Redis
cache. Hexagonal (ports & adapters), built on `java-maven-api-template`
conventions and `api-commons` shared infrastructure.

## Architecture

```
io.github.progmise.loans
├── application/
│   ├── ports/input/    Use case implementations ({Verb}{Entity}InputPort)
│   ├── ports/output/   Output port interfaces (data, cache)
│   └── usecases/       Use case interfaces ({Verb}{Entity}UseCase)
├── domain/
│   ├── model/          Domain model (User, Loan, Page)
│   ├── FeatureToggle   Feature flags (LOANS_CACHE_ON — Togglz/JDBC)
│   └── exception/      Domain exceptions
├── infrastructure/
│   ├── adapters/input/rest/    Controllers, DTOs, mappers, validators, request builders
│   ├── adapters/output/jpa/    JPA persistence adapter
│   ├── adapters/output/cache/  Redis adapter (LOANS_CACHE_ON gated, fail-open)
│   └── config/                 Spring configuration (JPA, Togglz, Swagger)
└── util/               Constants
```

Rules:
- Controllers never contain business logic — they call an input port.
- Domain/application never import `org.springframework.web` or adapters.
- Errors use the api-commons contract `{"errors":[{code,message,level,description}]}`
  via `ApiExceptionHandler` + `BadRequestException`/`NotFoundException`/…
  (auto-configured — do **not** redeclare the bean).
- Feature flags: constant in `domain/FeatureToggle` (snake_case value),
  `FeatureToggleHelper.isActive(FeatureToggle.X)` (fail-safe `false`).
- Generic, multi-API candidates belong in `api-commons` — use the
  `promote-to-lib` skill.

## Conventions

- Java 21, Maven wrapper, Lombok.
- Config only through env vars — never commit secrets. New vars go in
  `.env.example` (no values) + README table. Vars: `DB_URL`, `DB_USERNAME`,
  `DB_PASSWORD`, `REDIS_HOST`, `REDIS_PORT`, `REDIS_PASSWORD`, `REDIS_SSL`,
  `SENTRY_DSN` (optional), `PORT` (platform-injected).
- Local dev: `docker-compose` brings up Postgres + Redis; `.env.example`
  also documents a Supabase pooler alternative.
- Tests are hermetic — H2 + no Redis/Sentry.

## CI/CD

All pipeline logic lives in `progmise/reusable-workflows` (`@v1`,
`secrets: inherit`) — callers in `.github/workflows/` are thin; keep them so.
Pipeline: `Setup → Build artifact → Build image → SAST ‖ SCA ‖ CSA →
Tracing → Summary`; release adds `Validate → CI → Publish Image → Release`.
Deploy envs: `vars.DEPLOY_ENVIRONMENTS` (default `["pro"]`).

## Verify before done

```bash
./mvnw -B -ntp verify
docker build -t loans-api:dev .   # when touching Dockerfile/runtime config
```

## Branches

GitFlow: `main` is the default branch and holds releases; `development` is
the integration branch. Work lands on `<type>/<snake_description>` → PR to
`development` → PR to `main`. Types: `feature/`, `fix/`, `hotfix/`, `chore/`,
`docs/`, `refactor/`.

## Release

Bump `<version>` in `pom.xml`, merge `development` → `main`, then run the
**Release** workflow manually on `main` — it validates, runs CI, publishes
the Docker image and creates the tag + GitHub Release. Deploys go through
`deploy-manifest` (`deploy.yml` dispatch).

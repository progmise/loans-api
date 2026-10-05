# loans-api

REST API for managing users and loans. Java 21, Spring Boot 3, Spring Data
JPA (PostgreSQL), Redis cache. Hexagonal architecture (ports & adapters) —
built from `java-maven-api-template` conventions and sharing
[api-commons](https://github.com/progmise/api-commons) infrastructure
(error contract, validators, `FeatureToggleHelper`).

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
│   ├── adapters/output/jpa/    JPA persistence adapter (entities, Spring Data repositories, mappers)
│   ├── adapters/output/cache/  Redis cache adapter (gated by LOANS_CACHE_ON, fail-open)
│   └── config/                 Spring configuration (JPA, Togglz, Swagger)
└── util/               Constants
```

Error contract `{"errors":[{code,message,level,description}]}` and shared
validators come from `api-commons` (`ApiExceptionHandler` is auto-configured).

## Run

```bash
docker compose up --build     # app on :8080 + postgres + redis, image built from source
./mvnw spring-boot:run        # or run directly with env vars (see .env.example)
```

## Configuration

Everything is env-var driven — point the same variables at Supabase (Postgres)
and Upstash (Redis over TLS) to switch providers without code changes. See
`.env.example` for the local/Supabase/Upstash variants.

- `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` — datasource (local default: docker postgres)
- `REDIS_HOST`, `REDIS_PORT`, `REDIS_PASSWORD`, `REDIS_SSL` — cache (local default: docker redis)
- `CACHE_USERS_TTL` — user cache TTL in seconds (default 300)
- `SENTRY_DSN` / `SENTRY_ENABLED` — error tracking (off when unset)

Feature toggle `LOANS_CACHE_ON` is stored in the `FEATURE_TOGGLE` table
(auto-created on the app's datasource) and evaluated fail-safe — disable it
to bypass Redis reads/writes at runtime without redeploying.

## Test

```bash
./mvnw -B -ntp verify
```

Tests are self-contained: `@WebMvcTest` for controllers and H2 (in-memory) for
JPA — no Docker needed.

## CI/CD

Thin callers in `.github/workflows` → `progmise/reusable-workflows` API
pipelines (`@v1`, `secrets: inherit`):

- **CI Checks** on PRs — build, tests, SAST/SCA, container scan (CSA).
- **Integration** on merge — publishes image to Docker Hub (`:<sha>`,
  `:edge`/`:latest`) and deploys to non-pro envs in `DEPLOY_ENVIRONMENTS`.
- **Release** (manual on `main`) — bump `<version>` in `pom.xml`, run
  *Actions → Release*: publishes `:<version>` + `:latest`, creates the GitHub
  Release/tag. **Never deploys** — production goes through Deploy.
- **Deploy** (manual) — deploy any released version to one env
  (`pro`/`cert`/`pre`, must be in `vars.DEPLOY_ENVIRONMENTS`).

Docker image = `<DOCKER_USERNAME>/<repo>`. Required secrets/vars are listed
in the template's README (`DOCKER_USERNAME`, `DOCKER_TOKEN`, optional
`VERCEL_TOKEN`, `VERCEL_ORG_ID`, `VERCEL_PROJECT_ID`, `GRAFANA_OTLP_*`).
Vercel builds from `Dockerfile.vercel` and runs the OCI image; the app reads
`$PORT`.

## Docs

API contract: `docs/swagger.yaml` (OpenAPI 3.0); live UI at `/swagger-ui.html`.

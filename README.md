# loans-api

REST API for managing users and loans. Spring Boot, Spring Data JPA, PostgreSQL, Redis.
Hexagonal architecture (ports & adapters).

## Architecture

```
com.example.loanapi
├── application/
│   ├── ports/input/    Use case implementations ({Verb}{Entity}InputPort)
│   ├── ports/output/   Output port interfaces (data, cache)
│   └── usecases/       Use case interfaces ({Verb}{Entity}UseCase)
├── domain/
│   ├── model/          Domain model (User, Loan, Page)
│   └── exception/      Domain exceptions
├── infrastructure/
│   ├── adapters/input/rest/    Controllers, DTOs, mappers, validators, request builders, exception handler
│   ├── adapters/output/jpa/    JPA persistence adapter (entities, Spring Data repositories, mappers)
│   ├── adapters/output/cache/  Redis cache adapter
│   └── config/                 Spring configuration
└── utils/              Constants, validators, exceptions, tuples
```

## Run

```bash
docker compose up -d          # PostgreSQL + Redis (see docker-compose.yml)
./mvnw spring-boot:run        # API on :8080, mounted under /api/1.0
```

## Configuration

Everything is env-var driven — point the same variables at Supabase (Postgres)
and Upstash (Redis over TLS) to switch providers without code changes. See
`.env.example` for the local/Supabase/Upstash variants.

- `DB_URL`, `DB_USERNAME`, `DB_PASSWORD` — datasource (local default: docker postgres)
- `REDIS_HOST`, `REDIS_PORT`, `REDIS_PASSWORD`, `REDIS_SSL` — cache (local default: docker redis)
- `CACHE_USERS_TTL` — user cache TTL in seconds (default 300)

## Test

```bash
./mvnw test
```

Tests are self-contained: `@WebMvcTest` for controllers and H2 (in-memory) for
JPA — no Docker needed.

## Docs

API contract: `docs/swagger.yaml` (OpenAPI 3.0).

# loans-api

REST API for managing users and loans. Spring Boot, Spring Data JPA, PostgreSQL.
API docs generated via Spring REST Docs.

## Run

```bash
./mvnw spring-boot:run
```

DB connection is configured via env vars (defaults point to local PostgreSQL):

- `DB_URL` (default `jdbc:postgresql://localhost:5432/LOAN_API`)
- `DB_USERNAME` (default `postgres`)
- `DB_PASSWORD`

Schema is loaded from `src/main/resources/schema.sql` on startup.

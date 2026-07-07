# settlemate-be

SettleMate Kotlin Spring backend for merchant settlement reconciliation.

## Stack

- Kotlin, Spring Boot, REST
- MySQL, Redis, RabbitMQ
- Actuator, Datadog-style request logs

## API

- `GET /api/dashboard`
- `POST /api/settlements`

## Run

```bash
gradle test
gradle bootRun
```

See `requests.http` for sample payloads.

Contracts:
- `openapi.yaml`
- `src/main/resources/db/migration/V1__settlemate_schema.sql`

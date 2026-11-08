# Gestion-Objectifs — Savings Objectives Service

Manages user **savings objectives** and their **categories** for Money Minder MS.

## Tech stack
Java · Spring Boot · Spring Data JPA · MySQL · Spring Cloud (Eureka, Config, OpenFeign) · RabbitMQ (AMQP) · Spring Mail · springdoc-openapi · Actuator

## API — base path `/api/objectifs` (+ `/api/categories`) · port `8087`
| Method | Path | Action |
| --- | --- | --- |
| POST | `/api/objectifs/add` | Create an objective |
| GET | `/api/objectifs/getall` | List all |
| GET | `/api/objectifs/getbyid/{id}` | Get by id |
| GET | `/api/objectifs/byuser/{userId}` | List by user |
| PUT | `/api/objectifs/update` | Update |
| DELETE | `/api/objectifs/delete/{id}` | Delete |

## Data & messaging
MySQL `gestion_objectif` (port 3307) · RabbitMQ events · email notifications · calls the user service via OpenFeign.

## Run
```bash
mvn spring-boot:run
```

## Configuration
Settings live in `src/main/resources/application.properties`. Override the database, mail, and RabbitMQ credentials with environment variables outside local development.

## Part of Money Minder MS

One service of the **Money Minder MS** Spring Cloud platform. Full architecture and
the other services: [API-Gateway README](https://github.com/Money-Minder-MS/API-Gateway).
Start EurekaServer (8761) and Config-Server (8099) first.


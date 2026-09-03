# Trilheiros

A trail ecosystem where beginners can find experienced local guides to
explore with, leave reviews, and build a personal list of trails to hike.
Built as both a real product idea and a hands-on learning project — the
goal is to go from a bare Spring Boot scaffold to a deployed, containerized
application on AWS, learning Docker, PostgreSQL and cloud deployment along
the way.

## Features

**Done**
- User registration (entity + persistence layer)
- Trail catalog modeling (entity + persistence layer)
- User-trail interactions: save for later, mark as completed, rain reminder
- Trail reviews (rating + comment)

**Planned**
- Authentication (JWT)
- REST API (Service + Controller layers) for users and trails
- Distance-based trail search (Haversine formula)
- Photo uploads (AWS S3)
- Marketplace: hire an experienced guide to join you on a trail, with
  in-app payment and guide reviews
- Weather forecast integration
- Deployment to AWS

## Tech Stack

- **Java 21** / **Spring Boot 3.3**
- **Spring Data JPA** + **PostgreSQL**
- **Flyway** for versioned database migrations
- **Spring Security** (JWT auth, in progress)
- **Docker Compose** for local development
- **Lombok**

## Architecture

Modular monolith: a single deployable application, organized internally by
domain module (`user`, `trail`, and later `guide`) rather than by technical
layer alone. Each module is close to self-contained, which keeps the
codebase easy to navigate and leaves the door open to extracting a module
into its own service later, if it's ever needed.

```
com.trilheiros.trilheiros/
├── user/
│   ├── entity/
│   └── repository/
├── trail/
│   └── entity/
└── guide/            (planned — Phase 4)
```

## Getting Started

**Prerequisites:** Java 21, Docker Desktop.

```bash
# 1. Clone the repo
git clone https://github.com/MarcosAlexx/Trilheiros.git
cd Trilheiros

# 2. Start PostgreSQL locally
docker compose up -d

# 3. Run the application (applies Flyway migrations automatically)
./mvnw spring-boot:run
```

The API starts on `http://localhost:8080`. The Postgres container exposes
port `5433` (not the default `5432`) to avoid clashing with a native
Postgres install on the host machine.

## Roadmap

1. **Core** — user registration, JWT login, trail CRUD (admin) ⬅ in progress
2. **Social** — reviews, save/complete trails, rain reminders
3. **Geo + media** — distance-based search, photo uploads
4. **Marketplace** — hire local guides, in-app payments, guide reviews

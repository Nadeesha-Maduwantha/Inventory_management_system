# Head Office Stock Management System

The Head Office module of the Stock Management System. It connects the factory, head office, and branches into one system: product entry, branch stock orders and approvals, goods returns, expired products, credit sales, and reporting.

## Roles & Permissions

| Role | Permissions |
|---|---|
| **Operation General Manager (GM)** | Adds all users (Sales GM, Operation Manager, Operation User). Edits and views everything, including reports and user activity. |
| **Sales General Manager** | Views everything (reports, stock, orders, sales). Cannot add, edit, or delete data. |
| **Operation Manager** | Adds Operation Users only. Reviews and approves branch stock order requests. |
| **Operation User** | Dispatches approved stock orders to branches. Approves branch goods-return and expired-product requests. Cannot manage users, view activity history, or view/export reports. |

## Tech Stack

- **Backend**: Spring Boot 4 (Java 21), Maven, Spring Data JPA, Spring Security (JWT via httpOnly cookie), Flyway
- **Frontend**: Next.js (App Router) + TypeScript, Tailwind CSS
- **Database**: PostgreSQL 16
- **Monorepo**: npm workspaces for the Node side (`frontend`); `backend` is a Maven project living alongside it in the same repo

## Repository Structure

```
Head_Office/
├── backend/            # Spring Boot API
├── frontend/           # Next.js app
├── docker-compose.yml  # local Postgres
├── package.json        # root npm workspace manifest
└── README.md
```

## Prerequisites

| Tool | Version |
|---|---|
| JDK | 21 LTS |
| Maven | not required — use the included `./mvnw` wrapper |
| Node.js | 20 LTS or newer |
| npm | 10+ |
| Docker + Docker Compose | latest |

## Getting Started

```bash
# 1. Start Postgres
docker compose up -d

# 2. Install frontend dependencies (from repo root, via npm workspaces)
npm install

# 3. Run the backend
cd backend
./mvnw spring-boot:run

# 4. Run the frontend (from repo root, in a separate terminal)
npm run dev
```

- Backend: http://localhost:8080
- Frontend: http://localhost:3000
- Swagger UI: http://localhost:8080/swagger-ui.html

## Environment Variables

**Backend** (`backend/src/main/resources/application-local.yml`, or environment variables):

| Variable | Purpose |
|---|---|
| `JWT_SECRET` | Signing secret for JWTs. Defaults to a placeholder in `application.yml` — override for anything beyond local dev. |

**Frontend** (`frontend/.env.local`, copy from `.env.local.example`):

| Variable | Purpose |
|---|---|
| `NEXT_PUBLIC_API_BASE_URL` | Base URL of the backend API |

## Database Migrations

Flyway migrations live in `backend/src/main/resources/db/migration/`, named `V<number>__description.sql` (e.g. `V2__create_users_roles.sql`). They run automatically on backend startup.

## Scripts Reference

| Command | Location | Effect |
|---|---|---|
| `./mvnw spring-boot:run` | `backend/` | Run the API |
| `./mvnw test` | `backend/` | Run backend tests |
| `npm run dev` | root | Run the frontend dev server |
| `npm run build` | root | Build the frontend |
| `npm run lint` | root | Lint the frontend |

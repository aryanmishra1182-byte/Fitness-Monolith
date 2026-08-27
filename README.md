# 🏋️ Fitness Monolith

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 25"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Spring%20Security-JWT-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" alt="Spring Security"/>
  <img src="https://img.shields.io/badge/PostgreSQL-Neon-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL"/>
  <img src="https://img.shields.io/badge/React-Vite-61DAFB?style=for-the-badge&logo=react&logoColor=black" alt="React"/>
  <img src="https://img.shields.io/badge/Docker-Container-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker"/>
  <img src="https://img.shields.io/badge/Render-Cloud-46E3B7?style=for-the-badge&logo=render&logoColor=black" alt="Render"/>
</p>

<p align="center">
  <b>A production-ready, full-stack fitness management platform powered by Spring Boot, Spring Security, JWT, PostgreSQL, React, and Docker.</b>
</p>

<p align="center">
  <a href="https://fitness-mono-bs2k.onrender.com">🌐 Live Backend</a>
  &nbsp; • &nbsp;
  <a href="https://github.com/aryanmishra1182-byte/Fitness-Monolith">💻 Source Code</a>
  &nbsp; • &nbsp;
  <a href="https://fitness-mono-bs2k.onrender.com/swagger-ui.html">📚 Swagger Docs</a>
</p>

---

## 📌 Overview

**Fitness Monolith** is an end-to-end fitness management ecosystem built with a high-performance Spring Boot REST API and a responsive React (Vite) client. 

Engineered around a **robust monolithic backend architecture**, the system unifies identity management, token-based authorization, business services, and database persistence into a single maintainable deployment unit.

**Key Technical Highlights:**
* **Stateless Security:** Custom JWT authentication filter pipeline backed by BCrypt password hashing.
* **Granular RBAC:** Role-Based Access Control (`USER`, `ADMIN`) safeguarding domain endpoints.
* **Resilient Data Layer:** Spring Data JPA + Hibernate interfacing with a cloud-hosted Neon PostgreSQL instance.
* **Containerized Workflows:** Zero-friction local and cloud deployments orchestrated with Docker and Render.

---

## 🛠️ Tech Stack

| Layer | Technology | Primary Purpose |
| :--- | :--- | :--- |
| **Backend Core** | Java 25, Spring Boot 3.x | Core application runtime & REST APIs |
| **Security** | Spring Security, JJWT, BCrypt | Token authentication, password encryption, filter chains |
| **Persistence** | Spring Data JPA, Hibernate | ORM abstraction & database repository layer |
| **Database** | PostgreSQL, Neon Cloud | Managed relational cloud database |
| **Frontend** | React 18, Vite, JavaScript, CSS | Single-page application UI & client state |
| **Tooling & API** | Maven, Lombok, SpringDoc OpenAPI | Dependency management, boilerplate reduction, Swagger docs |
| **DevOps & Infra** | Docker, Docker Hub, Render | Image containerization, registry distribution, cloud hosting |

---

## 🏗️ Architecture & Authentication Flow

    [ React + Vite Client ] 
               │
               │  1. POST /api/auth/signin { email, password }
               ▼
  ┌─────────────────────────────────────────────────────────────┐
  │                   Spring Boot Monolith                      │
  │                                                             │
  │  [ Auth Controller ] ──> [ UserService ] (Verify BCrypt)    │
  │                                │                            │
  │                                ▼                            │
  │                         [ JwtUtils ]                        │
  │                                │ Generates Signed Token     │
  └────────────────────────────────┼────────────────────────────┘
                                   │
               ◄───────────────────┘
               │  2. Return JWT Payload
               │
               │  3. Subsequent Requests: Authorization: Bearer <token>
               ▼
  ┌─────────────────────────────────────────────────────────────┐
  │  [ JwtAuthFilter ] ──> Validate Token ──> Set SecurityCtx  │
  │                                │                            │
  │                                ▼                            │
  │  [ Protected Controllers ] ──> [ Service ] ──> [ JPA Repo ] │
  └───────────────────────────────────────────────────────┬─────┘
                                                          │ SQL Queries
                                                          ▼
                                              [ Neon PostgreSQL Cloud ]

---

## 📁 Project Structure

    Fitness-Monolith/
    ├── frontend/                     # React + Vite client
    │   ├── src/                      # UI components & styling
    │   │   ├── main.jsx
    │   │   └── styles.css
    │   ├── .env.example
    │   ├── index.html
    │   ├── package.json
    │   └── vite.config.js
    ├── src/                          # Spring Boot application
    │   ├── main/
    │   │   ├── java/com/project/fitness/
    │   │   │   ├── Controller/       # REST API endpoints
    │   │   │   ├── Service/          # Core business logic
    │   │   │   ├── Repository/       # Spring Data JPA interfaces
    │   │   │   ├── model/            # JPA entities (User, Roles, etc.)
    │   │   │   ├── dto/              # Request / Response payloads
    │   │   │   ├── security/         # JWT filters, configs & providers
    │   │   │   ├── exceptions/       # Global exception handlers
    │   │   │   └── FitnessMonolithApplication.java
    │   │   └── resources/
    │   │       └── application.properties
    │   └── test/                     # Unit & integration test suites
    ├── Dockerfile                    # Multi-stage production container build
    ├── pom.xml                       # Maven dependency tree
    ├── mvnw
    ├── mvnw.cmd
    └── README.md

---

## 📡 REST API Reference

### 🔐 Authentication Endpoints

#### 1. Register User
`POST /api/auth/register`

    {
      "name": "Aryan Mishra",
      "email": "aryan@example.com",
      "password": "SecurePassword123!"
    }

#### 2. Sign In
`POST /api/auth/signin`

    {
      "email": "aryan@example.com",
      "password": "SecurePassword123!"
    }

**Response (200 OK):**

    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
      "type": "Bearer",
      "user": {
        "id": 1,
        "name": "Aryan Mishra",
        "email": "aryan@example.com",
        "role": "ROLE_USER"
      }
    }

> **Authorizing Requests:** Include the returned token in subsequent headers:  
> `Authorization: Bearer <your-jwt-token>`

---

## 📖 Swagger / OpenAPI Documentation

Swagger UI and OpenAPI specifications are automatically served when the backend is running:

* **Local Swagger UI:** [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
* **Local OpenAPI Docs:** [http://localhost:8080/v3/api-docs](http://localhost:8080/v3/api-docs)
* **Production Live Backend:** [https://fitness-mono-bs2k.onrender.com](https://fitness-mono-bs2k.onrender.com)

---

## ⚙️ Environment Configuration

Set the following variables in your environment or local configuration:

### Backend Variables (`application.properties`)

    spring.datasource.url=${DB_URL}
    spring.datasource.username=${DB_USER}
    spring.datasource.password=${DB_PWD}
    spring.jpa.hibernate.ddl-auto=update

| Variable | Description | Example |
| :--- | :--- | :--- |
| `DB_URL` | Cloud/Local PostgreSQL JDBC URL | `jdbc:postgresql://ep-xyz.neon.tech/fitness_db` |
| `DB_USER` | Database username | `fitness_admin` |
| `DB_PWD` | Database password | `your_secret_password` |

### Frontend Variables (`frontend/.env`)
| Variable | Description | Example |
| :--- | :--- | :--- |
| `VITE_API_BASE_URL` | Backend Target URL | `http://localhost:8080` (Local) / `https://fitness-mono-bs2k.onrender.com` (Prod) |

---

## 🚀 Quick Start

### Prerequisites
* **Java 25+** & **Maven 3.9+**
* **Node.js 18+** & **npm**
* **Docker** *(optional)*

### 1. Clone the Repository

    git clone https://github.com/aryanmishra1182-byte/Fitness-Monolith.git
    cd Fitness-Monolith

### 2. Run Backend Locally

**Linux / macOS:**

    ./mvnw clean package -DskipTests
    java -jar target/fitness-monolith-0.0.1-SNAPSHOT.jar

**Windows:**

    .\mvnw.cmd clean package -DskipTests
    java -jar target\fitness-monolith-0.0.1-SNAPSHOT.jar

Backend will start on `http://localhost:8080`.

### 3. Run Frontend Locally

    cd frontend
    npm install
    npm run dev

Frontend development server will start on `http://localhost:5173`.

---

## 🐳 Docker Deployment

You can run the pre-built image directly from Docker Hub or build it locally.

### Run Pre-built Image

    docker run -d -p 8080:8080 \
      -e DB_URL="your-postgresql-url" \
      -e DB_USER="your-database-user" \
      -e DB_PWD="your-database-password" \
      aryanmishra1182/fitness-mono:latest

### Build Image Locally

    docker build -t aryanmishra1182/fitness-mono:latest .

---

## 🧪 Testing

Run automated tests via the Maven wrapper:

**Linux / macOS:**

    ./mvnw test

**Windows:**

    .\mvnw.cmd test

---

## 🔮 Roadmap

* [ ] Refresh Token mechanism with sliding expiration
* [ ] Workout and nutrition analytics tracking engine
* [ ] Global centralized Exception Handling & Problem Details (RFC 7807)
* [ ] Comprehensive Test Suite (JUnit 5 + Testcontainers for PostgreSQL)
* [ ] GitHub Actions CI/CD pipeline for automated Render deployments
* [ ] Rate limiting with Redis / Bucket4j

---

## 🧑‍💻 Author

**Aryan Mishra**  
Computer Science Engineering | Backend & Full-Stack Developer  
* GitHub: [@aryanmishra1182-byte](https://github.com/aryanmishra1182-byte)

---

<p align="center">
  Built with ☕ Java • 🌱 Spring Boot • ⚛️ React • 🐘 PostgreSQL • 🐳 Docker
</p>

# 🏋️ Fitness Monolith

<p align="center">
  <img src="https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java 25"/>
  <img src="https://img.shields.io/badge/Spring%20Boot-4.1.1-brightgreen?style=for-the-badge&logo=springboot&logoColor=white" alt="Spring Boot"/>
  <img src="https://img.shields.io/badge/Spring%20Security-JWT-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white" alt="Spring Security"/>
  <img src="https://img.shields.io/badge/PostgreSQL-Neon-4169E1?style=for-the-badge&logo=postgresql&logoColor=white" alt="PostgreSQL"/>
  <img src="https://img.shields.io/badge/React-Vite-61DAFB?style=for-the-badge&logo=react&logoColor=black" alt="React"/>
  <img src="https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white" alt="Docker"/>
  <img src="https://img.shields.io/badge/Render-Cloud-46E3B7?style=for-the-badge&logo=render&logoColor=black" alt="Render"/>
</p>

<p align="center">
  <b>A full-stack fitness management platform built with Spring Boot, Spring Security, JWT, PostgreSQL, React and Docker.</b>
</p>

<p align="center">
  <a href="https://fitness-mono-bs2k.onrender.com">🌐 Live Backend</a>
  &nbsp; • &nbsp;
  <a href="https://github.com/aryanmishra1182-byte/Fitness-Monolith">💻 Source Code</a>
</p>

---

## 📌 Overview

**Fitness Monolith** is a full-stack fitness management application built with a secure Spring Boot REST API and a modern React frontend.

The project follows a **monolithic architecture**, where authentication, authorization, business logic, database persistence, security and REST APIs are maintained inside a single Spring Boot application.

The React frontend communicates with the backend through REST APIs and uses JWT-based authentication for secured operations.

The project demonstrates practical implementation of:

- 🔐 JWT authentication
- 🛡️ Spring Security
- 👤 User management
- 👑 Role-based authorization
- 🗄️ PostgreSQL database integration
- 🌐 RESTful API development
- ⚛️ React + Vite frontend
- 🐳 Docker containerization
- ☁️ Cloud deployment
- 📚 Swagger/OpenAPI documentation
- 🔒 Environment-based configuration

---

# ✨ Features

## 🔐 Authentication & Security

- User registration
- User sign-in
- BCrypt password hashing
- JWT token generation
- JWT token validation
- Stateless authentication
- Role-based authorization
- Protected REST endpoints
- Admin-only endpoints
- Custom JWT authentication filter
- Spring Security filter chain
- CORS configuration
- Request validation

---

## 👤 User Management

- User registration
- User authentication
- Secure password storage
- User response DTOs
- Role-based access
- User information mapping
- Authentication-aware API requests

---

## 🌐 REST API

The backend provides RESTful endpoints for application functionality.

### Authentication

```http
POST /api/auth/register
POST /api/auth/signin
Authorization: Bearer <JWT_TOKEN>

                            🏗️ Architecture

                    ┌───────────────────────┐
                    │       React UI        │
                    │      Vite Frontend    │
                    └───────────┬───────────┘
                                │
                                │ REST / HTTP
                                ▼
                    ┌───────────────────────┐
                    │    Spring Boot API    │
                    │                       │
                    │     Controllers       │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │       Services        │
                    │    Business Logic     │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │    Spring Data JPA    │
                    │     Repositories      │
                    └───────────┬───────────┘
                                │
                                ▼
                    ┌───────────────────────┐
                    │      PostgreSQL       │
                    │      Neon Cloud       │
                    └───────────────────────┘
                             🛠️ Tech Stack
Backend
Technology
Purpose
Java 25
Programming language
Spring Boot 4.1.1
Backend framework
Spring Web MVC
REST API development
Spring Data JPA
Database persistence
Hibernate
ORM
Spring Security
Authentication & authorization
JWT
Stateless authentication
BCrypt
Password hashing
Bean Validation
Request validation
Lombok
Boilerplate reduction
Jackson
JSON serialization
Maven
Build & dependency management
PostgreSQL
Relational database
Neon
Cloud PostgreSQL
SpringDoc OpenAPI
API documentation
Frontend
Technology
Purpose
React
User interface
Vite
Frontend tooling
JavaScript
Application logic
CSS
Styling
Lucide React
UI icons
DevOps & Deployment
Technology
Purpose
Docker
Containerization
Docker Hub
Container image registry
Render
Cloud deployment
Git
Version control
GitHub
Source code hosting

📁 Project Structure
Fitness-Monolith/
│
├── .mvn/
│
├── frontend/
│   ├── src/
│   │   ├── main.jsx
│   │   └── styles.css
│   │
│   ├── .env.example
│   ├── index.html
│   ├── package.json
│   ├── package-lock.json
│   └── README.md
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── project/
│   │   │           └── fitness/
│   │   │               ├── Controller/
│   │   │               ├── Repository/
│   │   │               ├── Service/
│   │   │               ├── dto/
│   │   │               ├── exceptions/
│   │   │               ├── model/
│   │   │               ├── security/
│   │   │               └── FitnessMonolithApplication.java
│   │   │
│   │   └── resources/
│   │       └── application.properties
│   │
│   └── test/
│
├── Dockerfile
├── pom.xml
├── mvnw
├── mvnw.cmd
├── .gitignore
└── README.md
🔑 Authentication Flow
The application uses JWT-based stateless authentication.
                         Client
                           │
                           │ POST /api/auth/signin
                           ▼
                 ┌─────────────────────┐
                 │  Authentication API │
                 └──────────┬──────────┘
                            │
                            │ Validate credentials
                            ▼
                 ┌─────────────────────┐
                 │     UserService     │
                 └──────────┬──────────┘
                            │
                            │ Generate JWT
                            ▼
                 ┌─────────────────────┐
                 │       JwtUtils      │
                 └──────────┬──────────┘
                            │
                            │ JWT Token
                            ▼
                         Client
                            │
                            │ Authorization:
                            │ Bearer <token>
                            ▼
                 ┌─────────────────────┐
                 │ JwtAuthentication   │
                 │      Filter         │
                 └──────────┬──────────┘
                            │
                            │ Validate JWT
                            ▼
                 ┌─────────────────────┐
                 │ Protected Endpoint  │
                 └─────────────────────┘
🔐 JWT Authentication
After successful login, the backend generates a JWT token.
Example response:
{
  "token": "eyJhbGciOiJIUzI1NiJ9...",
  "user": {
    "id": 1,
    "email": "user@example.com",
    "role": "USER"
  }
}
For protected endpoints:
Authorization: Bearer <your-jwt-token>
📡 API Endpoints
Authentication
Register User
POST /api/auth/register
Example request:
{
  "name": "Aryan Mishra",
  "email": "aryan@example.com",
  "password": "password123"
}
Sign In
POST /api/auth/signin
Example request:
{
  "email": "aryan@example.com",
  "password": "password123"
}
📖 Swagger / OpenAPI
Swagger UI is available when the backend is running.
http://localhost:8080/swagger-ui.html
OpenAPI specification:
http://localhost:8080/v3/api-docs
Production backend:
https://fitness-mono-bs2k.onrender.com
⚙️ Environment Configuration
The backend uses environment variables for database configuration.
spring.datasource.url=${DB_URL}
spring.datasource.username=${DB_USER}
spring.datasource.password=${DB_PWD}
Set the following variables:
DB_URL=your-postgresql-url
DB_USER=your-database-user
DB_PWD=your-database-password
The frontend uses:
VITE_API_BASE_URL=https://fitness-mono-bs2k.onrender.com
For local development:
VITE_API_BASE_URL=http://localhost:8080
⚠️ Never commit real database credentials, passwords, JWT secrets or private environment variables to GitHub.
🚀 Getting Started
Prerequisites
Install:
Java 25+
Node.js 18+
npm
Git
Docker (optional)
🖥️ Run Backend Locally
Clone the repository:
git clone https://github.com/aryanmishra1182-byte/Fitness-Monolith.git
Navigate into the project:
cd Fitness-Monolith
Build the backend.
Windows
.\mvnw.cmd clean package
Linux / macOS
./mvnw clean package
Run the generated JAR:
java -jar target/fitness-monolith-0.0.1-SNAPSHOT.jar
Backend:
http://localhost:8080
⚛️ Run Frontend Locally
Open another terminal.
Navigate to the frontend:
cd frontend
Install dependencies:
npm install
Start the Vite development server:
npm run dev
Frontend:
http://localhost:5173
🐳 Docker
Build the Spring Boot application:
Windows
.\mvnw.cmd clean package -DskipTests
Linux / macOS
./mvnw clean package -DskipTests
Build the Docker image:
docker build -t aryanmishra1182/fitness-mono:latest .
Run the container:
docker run -p 8080:8080 \
  -e DB_URL="your-database-url" \
  -e DB_USER="your-database-user" \
  -e DB_PWD="your-database-password" \
  aryanmishra1182/fitness-mono:latest
☁️ Deployment
The backend is deployed using Docker and Render.
Spring Boot Application
          │
          ▼
        Maven
          │
          ▼
      JAR Build
          │
          ▼
        Docker
          │
          ▼
     Docker Image
          │
          ▼
      Docker Hub
          │
          ▼
        Render
          │
          ▼
     Live REST API
Production Backend
https://fitness-mono-bs2k.onrender.com
🗄️ Database
The application uses PostgreSQL for persistence.
Database architecture:
Spring Boot
     │
     ▼
Spring Data JPA
     │
     ▼
Hibernate ORM
     │
     ▼
PostgreSQL
     │
     ▼
Neon Cloud
Hibernate schema management is configured using:
spring.jpa.hibernate.ddl-auto=update

🌐 CORS
The backend is configured to allow frontend requests during development.
Development frontend:
http://localhost:5173
For production deployment, the deployed frontend origin should also be added to the backend CORS configuration.
🛡️ Security
Security is implemented using Spring Security and JWT.
The application includes:
JWT authentication
BCrypt password hashing
Stateless authentication
Role-based authorization
Protected REST endpoints
Custom JWT authentication filter
CORS configuration
Environment-based database configuration
Request validation
Authorization model:
USER
 └── User-level protected endpoints

ADMIN
 ├── User-level protected endpoints
 └── Admin-only endpoints
🧪 Testing
Run backend tests:
Windows
.\mvnw.cmd test
Linux / macOS
./mvnw test
Build without running tests:
./mvnw clean package -DskipTests
📦 Docker Image
Docker Hub image:
aryanmishra1182/fitness-mono
The Docker image packages the Spring Boot application into a Java runtime container.
💡 Why Monolithic Architecture?
This project intentionally follows a monolithic architecture.
All major backend responsibilities are contained inside one deployable Spring Boot application.
Authentication
      +
User Management
      +
Business Logic
      +
Database Access
      +
Security
      +
REST API
      │
      ▼
Single Spring Boot Application
Advantages:
Simple deployment
Straightforward development
Easy local testing
Centralized security
Lower infrastructure complexity
Easy project management
As the application grows, the architecture could evolve into a modular monolith or microservices architecture.
🔮 Future Improvements
[ ] Production frontend deployment
[ ] Improved fitness dashboard
[ ] Workout tracking
[ ] Fitness activity history
[ ] User profile management
[ ] Admin dashboard
[ ] Advanced role permissions
[ ] Refresh token mechanism
[ ] Global exception handling improvements
[ ] Automated CI/CD pipeline
[ ] Docker Compose development environment
[ ] Automated API testing
[ ] Integration testing
[ ] Application monitoring
[ ] Production logging
[ ] API rate limiting
📚 Learning Outcomes
This project demonstrates practical experience with:
Java backend development
Spring Boot
REST API development
Spring Security
JWT authentication
BCrypt password hashing
Role-based authorization
Spring Data JPA
Hibernate ORM
PostgreSQL
React
Vite
CORS
Maven
Docker
Docker Hub
Render
Cloud deployment
Environment configuration
Git
GitHub
🧑‍💻 Author
Aryan Mishra
Computer Science Engineering student focused on backend and full-stack development.
Core Focus
Java
Spring Boot
Spring Security
REST APIs
Backend Development
PostgreSQL
JPA / Hibernate
Docker
Cloud Deployment
React
GitHub
�
￼ 

⭐ Support
If you find this project useful or interesting, consider giving the repository a ⭐ on GitHub.
�
Built with ☕ Java • 🌱 Spring Boot • ⚛️ React • 🐘 PostgreSQL • 🐳 Docker 

�
Fitness Monolith 
Secure • Full Stack • Cloud Ready 
```

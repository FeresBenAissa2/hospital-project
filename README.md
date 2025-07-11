# Hospital Management Microservices System

## System Overview
A Spring Boot microservices application with:
- **Patient Service**: MongoDB (NoSQL) for patient records
- **Appointment Service**: PostgreSQL (SQL) for appointment management

## 📋 Table of Contents
- [Technologies Used](#-technologies-used)
- [Project Structure](#-project-structure)
- [Getting Started](#-getting-started)
- [API Documentation](#-api-documentation)
- [Data Models](#-data-models)
- [Configuration](#-configuration)
- [Troubleshooting](#-troubleshooting)

## 🛠 Technologies Used
- Java 17
- Spring Boot 3.x
- Spring Data MongoDB (Patient Service)
- Spring Data JPA/PostgreSQL (Appointment Service)
- Lombok
- Maven
- Docker (optional)

## 📂 Project Structure
hospital-system/
├── patient-service/ (MongoDB)
│ ├── src/main/java/com/esprit/patientservice/
│ │ ├── controller/PatientController.java
│ │ ├── model/Patient.java
│ │ ├── repository/PatientRepository.java
│ │ └── service/
└── appointment-service/ (PostgreSQL)
├── src/main/java/com/esprit/appointmentservice/
│ ├── controller/AppointmentController.java
│ ├── model/Appointment.java
│ ├── exception/ExceptionHandlerAdvice.java
│ └── service/

## 🚀 Getting Started

### Prerequisites
- Java 17 JDK
- Maven 3.8+
- MongoDB 6.0+
- PostgreSQL 15+

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/hospital-system.git
   cd hospital-system
   
## 🚀 Getting Started

### Prerequisites
- Java 17 JDK
- Maven 3.8+
- MongoDB 6.0+
- PostgreSQL 15+

## 📡 API Endpoints

### Patient Service
**Base URL:** `http://localhost:8081/api/v1/patient`

| Method | Endpoint       | Description                      | Request Body Example             |
|--------|----------------|----------------------------------|----------------------------------|
| POST   | `/`            | Create new patient               | `{"firstName":"John","lastName":"Doe","cin":"12345678"}` |
| GET    | `/{id}`        | Get patient by ID                | -                                |
| PATCH  | `/{id}`        | Partially update patient         | `{"lastName":"Smith"}`           |
| DELETE | `/{id}`        | Delete patient                   | -                                |
| GET    | `/name/{name}` | Get patient by last name         | -                                |

### Appointment Service
**Base URL:** `http://localhost:8082/api/v1/appointment`

| Method | Endpoint       | Description                      | Request Body Example             |
|--------|----------------|----------------------------------|----------------------------------|
| POST   | `/`            | Create new appointment           | `{"patientId":1,"doctorName":"Dr. Smith","department":"Cardiology"}` |
| GET    | `/{id}`        | Get appointment by ID            | -                                |
| PATCH  | `/{id}`        | Partially update appointment     | `{"status":"Cancelled"}`         |
| DELETE | `/{id}`        | Delete appointment               | -                                |
| GET    | `/`            | Get all appointments (paginated) | `?pageNbr=0&pageSize=10`         |

### keycloak Configuration  
**Docker Command:**
- Username : admin
- Password : admin
- Run On Port 9090
- docker run -p 9090:8080 -e KC_BOOTSTRAP_ADMIN_USERNAME=admin -e KC_BOOTSTRAP_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:26.2.5 start-dev
- login admin:admin
- create new realm named : hospital-service-realm 
- create new client : public-client
- client secret : G3rdIERIWPzrmhlXnCZNaDnVZd0VyGeq
- realm configuration: http://localhost:9090/realms/hospital-service-realm/.well-known/openid-configuration
- issuer url to put it in application.propertie file :
- spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:9090/realms/hospital-service-realm

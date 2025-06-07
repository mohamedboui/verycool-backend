 # VeryCool backend

Welcome to **VeryCool backend**, a Spring Boot application backed by a PostgreSQL database.

---

## Prerequisites

Before getting started, ensure the following dependencies are available on your system:

- Java version 21 or higher
- Maven (or use the included Maven Wrapper)

---

## Getting Started

### Cloning and Building

Clone the repository and navigate to the project root:

git clone https://github.com/mohamedboui/verycool-backend.git
cd verycool-backend and run mvn clean install.

## How to Run the Project

This application relies on **PostgreSQL** for data persistence.  
A `docker-compose.yml` file is provided in the root directory to quickly spin up the database environment.  
When launched through Docker, the schema is initialized automatically using the included `init_db.sql`.
## API Documentation

Once the application is up and running, you can explore the available endpoints and service descriptions through the following resources:

- **Interactive API Explorer (Swagger UI)**  
  Navigate to:  
  [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)






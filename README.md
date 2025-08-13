# Catalog-OrderMicroservices

A microservices project using Spring Boot, Kafka, and H2 database for managing product catalog and orders.

## Services

**Catalog Service**
- Manages product catalog
- REST endpoints to list and query products
- Listens for order events to update stock

**Order Service**
- Handles order creation
- Web UI for ordering products
- Publishes order events to Kafka

## Features

- RESTful APIs for product management
- Order creation with event-driven stock updates
- Kafka integration for inter-service communication
- H2 in-memory database for persistence
- Simple web UI using Thymeleaf
- Unit testing and validation
- OpenAPI/Swagger documentation
- Spring Boot Actuator for health monitoring

## Technologies

- Spring Boot
- Spring Data JPA
- Spring Kafka
- Thymeleaf
- H2 Database
- Docker & Docker Compose
- JUnit for testing
- Bean Validation
- OpenAPI/Swagger
- Spring Boot Actuator

## Running Locally

 **Start Kafka and Zookeeper**
   
   Use Docker Compose:
   ```bash
   docker-compose up -d
   ```

 **Access Applications**
   - Order Service UI: http://localhost:8080
   - Catalog Service API: http://localhost:8081
   - Swagger UI: http://localhost:8080/swagger-ui.html
   - Health Endpoints: http://localhost:8080/actuator/health

## API Endpoints

### Catalog Service (Port 8081)
- `GET /catalog/products` — List all products
- `GET /catalog/products/{id}` — Get product by ID

### Order Service (Port 8080)
- `GET /` — Product list and order form (web UI)
- `POST /createorder` — Create a new order


## Health Monitoring

Check service health:
- Catalog Service: http://localhost:8081/actuator/health
- Order Service: http://localhost:8080/actuator/health

## API Documentation

Access Swagger documentation:
- Catalog Service: http://localhost:8081/swagger-ui.html
- Order Service: http://localhost:8080/swagger-ui.html
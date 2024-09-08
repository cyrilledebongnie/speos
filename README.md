# Partner Management API

This project is a Spring Boot REST API for managing partners. It includes basic CRUD (Create, Read, Update, Delete) operations for managing partner entities, integrated with an in-memory H2 database.

## Overview

The API allows users to:
- Create a new partner
- Retrieve partner information
- Update existing partner details
- Delete a partner

It is built using Spring Boot, Spring Data JPA, and H2 database for easy testing and development.

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6.x or higher

### Project Structure

- `com.example.demo.model`: Contains the `Partner` entity class.
- `com.example.demo.repository`: Defines the `PartnerRepository` for interacting with the database.
- `com.example.demo.service`: Contains business logic for managing partners.
- `com.example.demo.controller`: Handles HTTP requests and maps them to the appropriate service methods.

### Steps to Run

1. Clone the repository or download the project.
   
   ```bash
   git clone https://github.com/cyrilledebongnie/speos.git
   ```
   
2. Build then Run the application using Maven:
  
  ```bash
  mvn clean install
  ./mvnw spring-boot:run
  ```

3. The application will start on the default port 8080. You can test the endpoints using a tool like Postman or CURL. Access the API at http://localhost:8080.

### Access the H2 Database Console
The H2 console is available at: http://localhost:8080/h2-console.
Use the following details to access it:
- JDBC URL: jdbc:h2:mem:testdb
- Username: sa
- Password: password

### Available Endpoints

- GET /api/partners/{id}: Retrieve a partner by ID.
- POST /api/partners: Create a new partner (requires a JSON body with the partner details).
- PUT /api/partners/{id}: Update a partner's details.
- DELETE /api/partners/{id}: Delete a partner.

### Health Check Endpoint
GET /actuator/health: Returns the health status of the application.

### TODO: Remaining Steps
The following tasks are pending:

1. Functional Tests
Add unit tests and integration tests using Spring Boot’s testing framework.
Ensure coverage for the controller, service layer, and repository.
2. Body Validation
Finish the body validation implementation using DTOs (Data Transfer Objects) and validation annotations like @NotNull, @Size, etc.
Return appropriate validation error messages if the request body is invalid.
3. Proper Error Handling and Message Validation
Add comprehensive error handling in the global exception handler (@ControllerAdvice).
Validate and return custom error messages for scenarios like:
Resource not found.
Invalid input data.
Database errors or validation failures.
Nice-to-Do Enhancements
1. Add Swagger for API Documentation
Integrate Springfox Swagger or SpringDoc OpenAPI to automatically generate API documentation. This will make testing and sharing API specs easier.
You can add Swagger UI, making it simple to explore and test the endpoints via a browser.
2. Add Paging and Sorting
Introduce paging and sorting to the GET /api/resource endpoint.
This can be done using Spring Data JPA’s built-in Pageable functionality.
3. Security / login
4. Customize the Actuator Health Check
Enhance the health check endpoint to monitor additional application metrics like database connectivity or third-party service statuses.
5. Add Docker Support
Add a Dockerfile and create a Docker image to simplify deployment.
This will allow the project to be run in any environment with Docker installed.
6. Add API Versioning
Implement versioning to allow for future upgrades without breaking existing clients.
For example, use /api/v1/resource for the current version.
### Conclusion
This project sets up a simple Spring Boot application with basic CRUD operations, an in-memory H2 database, and the foundation for validation and testing. The outlined TODOs and nice-to-have features provide room for further improvement and exploration of Spring Boot’s capabilities.

# Spring Boot CRUD REST API

A clean Spring Boot REST API for Product CRUD operations using **constructor-based dependency injection** (no Lombok, no `@Autowired` on fields).

## Tech Stack
- Java 17
- Spring Boot 3.2
- Spring Data JPA
- H2 In-Memory Database
- Bean Validation (jakarta.validation)

---

## Project Structure

```
src/main/java/com/example/crud/
├── CrudApplication.java
├── controller/
│   └── ProductController.java      ← REST endpoints
├── service/
│   ├── ProductService.java         ← Interface
│   └── ProductServiceImpl.java     ← Constructor-injected impl
├── repository/
│   └── ProductRepository.java      ← JPA Repository
├── model/
│   ├── Product.java                ← JPA Entity
│   ├── ProductDTO.java             ← Request body DTO
│   └── ApiResponse.java            ← Generic response wrapper
└── exception/
    ├── ResourceNotFoundException.java
    └── GlobalExceptionHandler.java
```

---

## Running the App

```bash
./mvnw spring-boot:run
```

API runs at: `http://localhost:8080`  
H2 Console: `http://localhost:8080/h2-console` (JDBC URL: `jdbc:h2:mem:cruddb`)

---

## API Endpoints

| Method | Endpoint                        | Description            |
|--------|---------------------------------|------------------------|
| GET    | /api/products                   | Get all products       |
| GET    | /api/products/{id}              | Get product by ID      |
| POST   | /api/products                   | Create a new product   |
| PUT    | /api/products/{id}              | Update a product       |
| DELETE | /api/products/{id}              | Delete a product       |
| GET    | /api/products/search?keyword=xx | Search by keyword      |

---

## Sample Request Body (POST / PUT)

```json
{
  "name": "Samsung Galaxy S24",
  "description": "Android flagship smartphone",
  "price": 899.99,
  "quantity": 30
}
```

## Sample Response

```json
{
  "success": true,
  "message": "Product created successfully",
  "data": {
    "id": 4,
    "name": "Samsung Galaxy S24",
    "description": "Android flagship smartphone",
    "price": 899.99,
    "quantity": 30,
    "createdAt": "2024-06-04T10:00:00",
    "updatedAt": "2024-06-04T10:00:00"
  },
  "timestamp": "2024-06-04T10:00:00"
}
```

---

## Bruno Collection

Import the `bruno-collection/` folder into [Bruno](https://www.usebruno.com/) to test all endpoints.

Set the environment to `local` (baseUrl = `http://localhost:8080`).

| File                                | Description                   |
|-------------------------------------|-------------------------------|
| get-all-products.bru                | GET all products              |
| get-product-by-id.bru               | GET product by ID             |
| create-product.bru                  | POST create product           |
| update-product.bru                  | PUT update product            |
| delete-product.bru                  | DELETE product                |
| search-products.bru                 | GET search by keyword         |
| get-product-not-found.bru           | GET 404 error case            |
| create-product-validation-error.bru | POST 400 validation error     |

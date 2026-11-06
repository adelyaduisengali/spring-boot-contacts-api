# Spring Boot CRUD Application – Contact Management

A REST API built with Java and Spring Boot that performs create, read, update
and delete operations on contacts stored in a PostgreSQL database.

## Features
- Create, view, update and delete contacts
- DTO layer to separate API data from database entities
- REST endpoints tested with Postman
- Data stored in PostgreSQL via Spring Data JPA

## Project structure
- `controller` – REST controller that handles HTTP requests (`UserController`)
- `model/entity` – JPA entity mapped to the database table (`User`)
- `model/dto` – Data Transfer Object for API requests and responses (`UserDTO`)
- `repository` – database access with Spring Data JPA (`UserRepository`)
- `service` – business logic (`UserService` interface and `UserServiceImpl`)

## Tech stack
Java · Spring Boot · Spring Data JPA · PostgreSQL · Maven · Postman

## How to run
1. Create a PostgreSQL database named `oop`
2. Set your database username and password in `src/main/resources/application.properties`
3. Run `As4Application.java` in IntelliJ IDEA
4. Send requests to `http://localhost:8080/api/contacts` using Postman

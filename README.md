# Software Mind Application

This is a simple REST application for a to-do list.

## Installation

1. Clone this repository
2. Create a sample database with following MySQL code:
```sql
create database smapp;
create table tasks
       (
           ID SERIAL,
           TITLE VARCHAR(50) CHARSET utf8 NOT NULL,
           DESCRIPTION VARCHAR(100) CHARSET utf8 NOT NULL,
           FINISHED boolean not null default 0
       );
create user 'test_user'@'localhost' IDENTIFIED BY 'test_password';
grant all privileges ON smapp.tasks TO 'test_user'@'host';
```
3. Build and run SmApplication from SMApp\src\main\java\com\smapp
4. Go to http://localhost:8080/tasks

## Used technologies

- Java
- Spring Boot
- Lombok
- Thymeleaf

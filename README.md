# used car

This is a website showing information of used cars.
First of all, we need a car Make. Under this Make, different model belongs to different Make. And different cars can be added under respective model.

##### Such as

Make: Toyota
Model: Camry
Car Info: 2007 Toyota Camry Solara SLE

# technology

##### frontend  :  js

Vue.js: Js + Element-ui

##### Backend  :  java

Spring Boot + Spring Security + Mybatis Plus + Redis

##### Database

Mysql8

##### Test Tool

Swagger2

# Requirements

##### SPA

VUE is a js framework that can implement single page application. So I use VUE.js.

##### MVC on the server with routing

Spring Boot is based on MVC, and different requests (Restful requests) will call different methods in the controller according to Routing.

##### Authentication

I use "Spring Security" as Authentication to generate tokens and verify tokens. I set a whitelist that does not require token verification in the SecurityConfig.java file, and other require must carry token.

##### ORM

In the core business, I designed three tables as entity classes. The entity class is placed under the "entity" package and corresponds to the tables in the database.

##### Dependency Injection

Spring Boot framework implements dependency injection. I only need to add an annotation(such as: @RestController @Service @Configuration @Data) above the class name to inject the class into the system.

##### Unit Testing

Swagger2: http://54.219.47.84:8081/swagger-ui.html

You can click the link above to query the interface test.

Note that many methods require Authorization(token).

##### Authorization

There is an authorization logic here. In this system, different users can have different roles, and different roles can view different pages. In this system,  "admin" is an Administrator, so he has all permissions. "Tom" is a Normal User, he has all the permissions under the Car Manage directory, but he can only view the System Manage directory(He can not manipulate the System Manage directory).

# Link

Frontend: https://github.com/jackisapirate/Car_frontend
Backend: https://github.com/jackisapirate/Car_backend
Project presentations: http://54.219.47.84/
Swagger2: http://54.219.47.84:8081/swagger-ui.html


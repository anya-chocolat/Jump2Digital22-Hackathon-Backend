## Jump2Digital22 Hackathon

### #Jump2Digital22 Hackathon Backend challenge

[![CodeFactor](https://www.codefactor.io/repository/github/anya-chocolat/jump2digital22-hackathon-backend/badge)](https://www.codefactor.io/repository/github/anya-chocolat/jump2digital22-hackathon-backend) <br>
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=anya-chocolat_Jump2Digital22-Hackathon-Backend&metric=alert_status)](https://sonarcloud.io/summary/new_code?id=anya-chocolat_Jump2Digital22-Hackathon-Backend)

> Una API REST construída con Spring Boot, Maven, JPA hibernate and SQL

### Usage

La aplicación contiene:

* Un metodo para importar datos de un archivo JSON a la base de datos
* Un endpoint que devuelva la lista entera de las compañías
  > @RequestMapping ruta: "/companies"
* Un endpoint que devuelva las compañías ordenadas por tamaño
  > @RequestMapping ruta: "/companies/by-size"
* Un endpoint que devuelva las compañías ordenadas por fecha de creación
  > @RequestMapping ruta: "/companies/by-year"
* Un endpoint que devuelva los siguientes datos:
    * Número de empresas que hay en cada industria
    * Número de empresas que hay por cada rango de tamaños
    * Número de empresas que hay en cada año de creación
  > @RequestMapping ruta: "/companies/count"

### Structure

La base de datos contiene una tabla que se llama "company".

&emsp; ***Class diagram*** de la tabla: <br>
&emsp; ![Company table class diagram](https://github.com/anya-chocolat/Jump2Digital22-Hackathon-Backend/blob/main/Hackathon%20company%20Class%20DIagram.png?raw=true "Company table class diagram")

Los endpoints están definidos en la clase CompanyController y utilizan los métodos de la clase CompanyService que a su vez están utilizando las queries definidos en la repositoria CompanyRepository.

También incluye los tests para asegurar la funcionalidad correcta de los endpoints.

### Tecnologías

- [Java 17](https://docs.oracle.com/en/java/javase/17/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [JPQL](https://docs.oracle.com/javaee/6/tutorial/doc/bnbtg.html)

### Herramientas

- [SpringBoot Initializr](https://start.spring.io/) para generar un proyecto de Spring con Maven
- [Postman](https://www.getpostman.com/) para realizar peticiones (y ver las respuestas) a la aplicación
- [MySQL Workbench](https://www.mysql.com/products/workbench/) para ver las tablas de la base de datos
- [IntellIJ](https://www.jetbrains.com/idea/) el IDE utilizado

### Contact info

> anya.chocolat@gmail.com || Anya Popova Popova

### License

[Common Development and Distribution License](https://opensource.org/licenses/CDDL-1.0)
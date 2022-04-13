# Formación Adevinta > Factoría F5 > Bases de Datos Relacionales

Este repositorio sirve como soporte práctico en la formación de bases de datos para Factoría F5.

Requiere:
- Java 11
- Docker

Referencias de la implementación:

- [Spring Boot Initializr](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=2.6.6&packaging=jar&jvmVersion=11&groupId=com.adevinta.factoriaf5.databases&artifactId=formacion&name=formacion&description=Demo%20project&packageName=com.adevinta.factoriaf5.databases&dependencies=mybatis,flyway,web,postgresql) como base del proyecto
- Arquitectura hexagonal ([referencia#1](https://netflixtechblog.com/ready-for-changes-with-hexagonal-architecture-b315ec967749), [referencia#2](https://reflectoring.io/spring-hexagonal/))
- [MyBatis 3 Spring Boot Starter](https://github.com/mybatis/spring-boot-starter) Para ejemplificar el desarrollo con SQL
  - [Getting started](https://mybatis.org/mybatis-3/getting-started.html)
- [PostgreSQL](https://www.postgresql.org/docs/14/sql.html) como sistema gestor de bases de datos
  - [SQL Tutorial](https://www.sqltutorial.org/)
- [Flyway](https://flywaydb.org/documentation/getstarted/how) para ejecutar actualizaciones de la base de datos
- [Docker Compose](https://hub.docker.com/_/postgres) para levantar PostgreSQL en local

La ejecución de los tests inicializa una base de datos con datos inicializados

```
./gradlew test
```

La ejecución en local requiere arrancar la imagen dockerizada de la base de datos

```
docker-compose up -d

./gradlew bootRun

...
docker-compose down

```

## Caso práctico

Iterar el desarrollo de una API para un buscador de películas haciendo émfasis sólo en lo relacionado con la capa de persistencia con implementación en SQL.

Una película en nuestro sistema constará de:

```
- id          (texto):    identificador de la película
- title       (texto):    el título de la película
- synopsis    (texto):    el argumento de la película
- releaseYear (número):   el año de estreno de la película
- featurettes (lista):    listado de recursos multimedia asociados (tráilers, teasers, ...)
  - name      (texto):    el nombre del recurso multimedia
  - url       (texto):    la URL al recurso multimedia
- platforms   (lista):    listado de plataformas en las que la película está disponible
  - id        (texto):    identificador de la plataforma
  - name      (texto):    nombre de la plataforma
```

Ejemplo del recurso esperado para una película
`movie json`

```json
{
  "id": "A202204010001",
  "title": "Matrix",
  "synopsis": "Thomas Anderson lleva una doble vida: por el día es programador en una importante empresa de software, y por la noche un hacker informático llamado Neo. Su vida no volverá a ser igual cuando unos misteriosos personajes le inviten a descubrir la respuesta a la pregunta que no le deja dormir: ¿qué es Matrix?",
  "releaseYear": 1999,
  "featurettes": [
    {
      "name": "Tráiler oficial",
      "url": "https://www.youtube.com/watch?v=OM0tSTEQCQA"
    },
    {
      "name": "Teaser #1",
      "url": "https://www.youtube.com/watch?v=QOLwRpD8tTY"
    }
  ],
  "platforms": [
    {
      "id": "P202204010001",
      "name": "HBO Max"
    },
    {
      "id": "P202204010002",
      "name": "Netflix"
    }
  ]
}
```

Como objetivo principal, el buscador debe permitir:

- buscar películas por título
- buscar películas por rango de años de estreno
- buscar películas por plataformas de streaming donde estén disponibles

Adicionalmente, para ejemplificar las actualizaciones nos permitirá:

- añadir nuevas películas

Para poder consultar las películas con más datos en la base de datos, debe permitir:

- paginación de resultados

## Diseño de la API

### Dominio

Como entidades principales,

**domain/movie** 

Representación lógica de las películas

**domain/platform** 

Representación lógica de las plataformas

### Exposición para clientes HTTP

**PlatformController** 

- expondrá lo necesario para que el cliente de la API pueda obtener las plataformas disponibles en formato JSON
- queda fuera de este ejercicio la gestión de plataformas

**MovieController**

- expondrá los endpoints de consulta y actualización de películas en formato JSON

### Capa de persistencia

**PlatformMyBatisRepository**

- implementación del PlatformRepository basada en MyBatis

**MovieMyBatisRepository**

- implementación del MovieRepository basada en MyBatis



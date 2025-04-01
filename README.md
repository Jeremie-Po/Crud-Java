### FIRST CRUD JAVA SPRING HIBERNATE GRADLE

Merci à David Elbaze pour son cours !

### Installation

https://delbaze.notion.site/Java-Spring-Hibernate-Gradle-9394a3f261354e50b18591a7de1a7079#86d2ef8e6dd64042bd10abfcb5c250f5

https://start.spring.io/

### COMMANDS

launch the program :

```
./gradlew bootRun

```

ou
Auto rebuild (hot reload) with spring-boot-dev-tool

```
./gradlew -t :bootJar

Puis DANS UN AUTRE TERMINAL !

./gradlew bootRun
```

cela lance automatiquement docker
le bootJar observe les changements et rebuild le tout

### Create a basic controller

* Create a folder controllers at : src/main/java/com.immo.demo.controllers
* create a file : HelloController.java

```
package com.immo.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class HelloController {
    private static final Logger logger = Logger.getLogger(HelloController.class.getName());

    private static final String template = "Hello, %s!";

    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        logger.info("Nom recu : " + name);
        return  String.format(template, name);
    }
}
```

for
axplanation : https://delbaze.notion.site/Java-Spring-Hibernate-Gradle-9394a3f261354e50b18591a7de1a7079?pvs=97#a720bfeb66674318babec92128b62f68

### create entity

https://delbaze.notion.site/Java-Spring-Hibernate-Gradle-9394a3f261354e50b18591a7de1a7079?pvs=97#df9abe3e44a24d3aa8ff3cbe11dc76b7

* Create an entity folder ar src/main/java/com/immo/demo/entities
* create an entity file : AnnonceEntity.java

```
package com.david.immo.demo.entities;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "annonces_immobilieres")
public class AnnonceEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String titre;

    private String description;

    private double prix;

    private String emplacement;

    @Column(name = "date_creation")
    private LocalDateTime dateCreation;

    public AnnonceEntity() {
        // Constructeur vide nécessaire pour Hibernate
    }

    public AnnonceEntity(String titre, String description, double prix, String emplacement, LocalDateTime dateCreation) {
        this.titre = titre;
        this.description = description;
        this.prix = prix;
        this.emplacement = emplacement;
        this.dateCreation = dateCreation;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }


    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getEmplacement() {
        return emplacement;
    }

    public void setEmplacement(String emplacement) {
        this.emplacement = emplacement;
    }

    public LocalDateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(LocalDateTime dateCreation) {
        this.dateCreation = dateCreation;
    }
}

```

* add to the src/main/resources/application.properties file :

```
spring.jpa.hibernate.ddl-auto=create
  
 ```

it ll synchronise the architecture of the bd with the files

* in the compose.yml file, add Adminer :

```
services:
  postgres:
    image: 'postgres:latest'
    environment:
      - 'POSTGRES_DB=mydatabase'
      - 'POSTGRES_PASSWORD=secret'
      - 'POSTGRES_USER=myuser'
    ports:
      - '5432'

  adminer:
    image: adminer
    restart: always
    ports:
      - 8080:8080

```

then :

```
docker compose up --build -d
```
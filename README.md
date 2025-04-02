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

### fixtures populate the base

add to the application.propertie file :

```
spring.jpa.defer-datasource-initialization=true 
spring.sql.init.mode=always // 'never' to not initialise the database every time
spring.jpa.hibernate.ddl-auto=create // 'update' stop loading the data 
```

at every lauch it ll initialise the base and execute the data.sql file

```
DROP TABLE IF EXISTS "annonces_immobilieres";
CREATE TABLE "public"."annonces_immobilieres" (
  "prix" double precision NOT NULL,
  "date_creation" timestamp(6),
  "id" bigint NOT NULL,
  "description" character varying(255),
  "emplacement" character varying(255),
  "titre" character varying(255),
  CONSTRAINT "annonces_immobilieres_pkey" PRIMARY KEY ("id")
) WITH (oids = false);

INSERT INTO "annonces_immobilieres" ("prix", "date_creation", "id", "description", "emplacement", "titre") VALUES
   (340000,	CURRENT_TIMESTAMP,	1,	'description annonce 1',	'Lyon',	'Annonce 1'),
   (240000,	CURRENT_TIMESTAMP + INTERVAL '1 day',	2,	'description annonce 2',	'paris',	'Annonce 2'),
   (4000000,	CURRENT_TIMESTAMP + INTERVAL '2 day',	3,	'description annonce 3',	'Bordeaux',	'Annonce 3');

```
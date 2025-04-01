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
Auto rebuild (hot reload) with spring-boot-dev-tool

```
./gradlew -t :bootJar

Puis DANS UN AUTRE TERMINAL !

./gradlew bootRun
```
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
for axplanation : https://delbaze.notion.site/Java-Spring-Hibernate-Gradle-9394a3f261354e50b18591a7de1a7079?pvs=97#a720bfeb66674318babec92128b62f68
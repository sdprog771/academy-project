package com.techpro.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/***
 * This is a project created for TechPro Academy as the final assignment project of the program.
 * It simply concerns a web application that supports e-commerce functionalities.
 *
 * The project is developed in Java openJDK18 with Springboot framework and Maven using the following dependencies:
 * springdoc-openapi-ui, springfox-swagger2, lombok, pring-boot-starter-web, spring-boot-starter-jersey,
 * spring-boot-starter-jdbc, maven-javadoc-plugin, spring-boot-starter-data-jpa, mysql-connector-java,
 * spring-boot-devtools, spring-boot-starter-test, junit-vintage-engine, mysql-connector-java.
 *
 * The project also is connected to the 'final_project' database which was developed in MySQL Workbench.
 * URL, username and password are provided upon starting the application.
 *
 * @Author Sophia Damianidou
 * @Version 1.0
 * @Since 2023/06/25
 *
 *
 *@SpringBootApplication Create a Sptingboot application
 *@EnableAutoConfiguration Enable the auto-configuration of Spring ApplicationContext
 *@ComponentScan  Define the packages to be scanned: "com.techpro.project"
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.techpro.project"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

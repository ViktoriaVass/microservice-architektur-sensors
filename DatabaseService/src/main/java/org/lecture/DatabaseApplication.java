/**
 * The DatabaseApplication class serves as the entry point for the database service application.
 * The main method in this class starts the Spring Boot application, allowing the database service to run.
 * To execute the database service, simply run this class with the main method.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 10.11.2023
 * @package: org.lecture
 **/

package org.lecture;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Indicates that this class is a Spring Boot application, enabling various features.
import org.springframework.stereotype.Service;

@SpringBootApplication
@Service
public class DatabaseApplication {

    @Value("${spring.datasource.driver-class-name}")
    private String databaseDriver;

    @Value("${spring.datasource.url}")
    private String databaserUrl;

    @Value("${spring.datasource.username}")
    private String databaseUsername;

    @Value("${spring.datasource.password}")
    private String databasePassword;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

}

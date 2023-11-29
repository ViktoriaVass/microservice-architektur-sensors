/**
 * The ApiGateway class serves as a centralized interface that aggregates, manages, and controls access to APIs within a distributed system.
 * The main method in this class starts the Spring Boot application, allowing the database service to run.
 * To run the database service, run ConfigurationApplication, ServiceRegistryApplication, ApiGatewayApplication and then this class.
 */

package org.lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
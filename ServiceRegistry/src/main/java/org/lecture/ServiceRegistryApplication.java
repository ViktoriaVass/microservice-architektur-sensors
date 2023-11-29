/**
 * The ServiceRegistration class registers its clients as services.
 * The main method in this class starts the Spring Boot application, allowing the service registry to run.
 * To run this class, run ConfigurationApplication first.
 */

package org.lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ServiceRegistryApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryApplication.class, args);
    }
}
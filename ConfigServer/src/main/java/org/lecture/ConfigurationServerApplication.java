/**
 * The ConfigurationServerApplication class runs a centralized config server.
 * The main method in this class starts the Spring Boot application, allowing the config server to run.
 * To run the config server, simply run this class with the main method.
 */

package org.lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Indicates that this class is a Spring Boot application, enabling various features.
import org.springframework.cloud.config.server.EnableConfigServer; // Enables a config server that can communicate with other applications.
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableConfigServer
@SpringBootApplication
@EnableEurekaServer
public class ConfigurationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServerApplication.class, args);
    }
}

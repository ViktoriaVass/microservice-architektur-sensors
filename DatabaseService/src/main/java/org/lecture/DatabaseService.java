/**
 * The DatabaseService class serves as the entry point for the database service application.
 * The main method in this class starts the Spring Boot application, allowing the database service to run.
 * To execute the database service, simply run this class with the main method.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 10.11.2023
 * @package: org.lecture
 **/

package org.lecture;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Indicates that this class is a Spring Boot application, enabling various features.
import org.springframework.boot.autoconfigure.domain.EntityScan; // Specifies the base package(s) to scan for JPA entities within the application.

@SpringBootApplication
@EntityScan(basePackages = "org.lecture")
public class DatabaseService {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseService.class, args);
	}

}

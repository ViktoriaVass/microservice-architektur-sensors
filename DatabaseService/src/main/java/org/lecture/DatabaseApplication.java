/**
 * The DatabaseApplication class serves as the entry point for the database service application.
 * The main method in this class starts the Spring Boot application, allowing the database service to run.
 * To run the database service, run ConfigurationApplication, ServiceRegistryApplication, ApiGatewayApplication and then this class.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 10.11.2023
 * @package: org.lecture
 **/

package org.lecture;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Indicates that this class is a Spring Boot application, enabling various features.
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableDiscoveryClient // Activates the Discovery Client for service discovery
@SpringBootApplication
@Service
public class DatabaseApplication {

    /**
     * The database driver
     */
    @Value("${spring.datasource.driver-class-name}")
    private String databaseDriver;

    /**
     * The database URL
     */
    @Value("${spring.datasource.url}")
    private String databaserUrl;

    /**
     * The username for the database
     */
    @Value("${spring.datasource.username}")
    private String databaseUsername;

    /**
     * The password for the database
     */
    @Value("${SPRING_DATASOURCE_PASSWORD}")
    private String databasePassword;

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

}

/**
 * REST Controller to handle service instance requests based on application name.
 */
@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * Retrieves a list of service instances for a given application name.
     *
     * @param applicationName The name of the application to fetch service instances.
     * @return A list of ServiceInstance objects representing instances of the specified application.
     */
    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(
            @PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}

/**
 * The ConfigurationServerApplication class runs a centralized config server.
 * The main method in this class starts the Spring Boot application, allowing the config server to run.
 * To run the config server, simply run this class with the main method.
 */

package org.lecture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; // Indicates that this class is a Spring Boot application, enabling various features.
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer; // Enables a config server that can communicate with other applications.
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@EnableConfigServer
@SpringBootApplication
@EnableDiscoveryClient // Activates the Discovery Client for service discovery
public class ConfigurationServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigurationServerApplication.class, args);
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

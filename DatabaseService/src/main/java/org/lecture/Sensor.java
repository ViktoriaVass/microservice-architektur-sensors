/**
 * The Sensor class represents a sensor entity in the system. The instances of this class
 * are entities that can be persisted to a relational database.
 * The class provides a default constructor for use by JPA, and a parameterized constructor
 * for creating instances with specific attribute values.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 10.11.2023
 * @package: org.lecture
 **/

package org.lecture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
@Entity
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long sensor_id;

    private String name;
    private String location;
    private Boolean isActive;
    private String type;

    @OneToMany(mappedBy = "sensor", cascade = CascadeType.ALL)
    private List<Measurement> measurements;

    public Sensor() {}     // default constructor for JPA

    public Sensor(String name, String location, Boolean isActive, String type) {
        this.name = name;
        this.location = location;
        this.isActive = isActive;
        this.type = type;
    }

    /*
    curl -i -H "Content-Type:application/json" -d '{"name": "Sensor_1", "location": "kitchen", "isActive": "true", "type": "indoor"}' http://localhost:8080/sensors
    curl -i -H "Content-Type:application/json" -d '{"name": "Sensor_2", "location": "livingroom", "isActive": "true", "type": "indoor"}' http://localhost:8080/sensors
    curl -i -H "Content-Type:application/json" -d '{"name": "Sensor_3", "location": "pool", "isActive": "true", "type": "water"}' http://localhost:8080/sensors
    curl -i -H "Content-Type:application/json" -d '{"name": "Sensor_4", "location": "garden", "isActive": "true", "type": "outdoor"}' http://localhost:8080/sensors
    curl -X PUT -H "Content-Type:application/json" -d '{"name": "Sensor_4", "location": "livingroom", "isActive": "true", "type": "indoor"}' http://localhost:8080/sensors/4
     */
}
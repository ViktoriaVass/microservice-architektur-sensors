/**
 * The Measurement class represents a measurement entity in the system. The instances of this class
 * are entities that can be persisted to a relational database.
 * The class provides a default constructor for use by JPA, and a parameterized constructor
 * for creating instances with specific attribute values.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 12.11.2023
 * @package: org.lecture
 **/

package org.lecture;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long measurement_id;

    @ManyToOne
    @JoinColumn(name = "sensor_id")
    private Sensor sensor;
    private Date timestamp;
    private int temperature;
    private int humidity;

    public Measurement() {}     // default constructor for JPA

    public Measurement(Sensor sensor, Date timestamp, int temperature, int humidity) {
        this.sensor = sensor;
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}

/*
curl -i -H "Content-Type:application/json" -d '{"sensor": {"name": "Sensor_1", "location": "kitchen", "isActive": true, "type": "indoor"}, "timestamp": "2023-05-20T15:00:00", "temperature": 22, "humidity": 60}' http://localhost:8080/measurements
*/
/**
 * The MeasurementEntity class represents a measurement entity in the system. The instances of this class
 * are entities that can be persisted to a relational database.
 * The class provides a default constructor for use by JPA, and a parameterized constructor
 * for creating instances with specific attribute values.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 12.11.2023
 * @package: org.lecture.entity
 **/

package org.lecture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.Hidden;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "measurement")
public class MeasurementEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "measurement_id")
    private Long measurement_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sensor_id")
    private SensorEntity sensorEntity;

    @Column(name = "timestamp")
    private Date timestamp;

    @Column(name = "temperature")
    private int temperature;

    @Column(name = "humidity")
    private int humidity;

    public MeasurementEntity() {
    }     // default constructor for JPA

    @JsonIgnore
    public void setSensor(SensorEntity sensor) {
        this.sensorEntity = sensor;
        sensor.getMeasurementEntities().add(this);
    }

    public MeasurementEntity(Date timestamp, int temperature, int humidity) {
        this.timestamp = timestamp;
        this.temperature = temperature;
        this.humidity = humidity;
    }
}
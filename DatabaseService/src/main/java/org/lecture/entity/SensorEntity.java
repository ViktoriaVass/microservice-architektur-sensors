/**
 * The SensorEntity class represents a sensor entity in the system. The instances of this class
 * are entities that can be persisted to a relational database.
 * The class provides a default constructor for use by JPA, and a parameterized constructor
 * for creating instances with specific attribute values.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 10.11.2023
 * @package: org.lecture.entity
 **/

package org.lecture.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sensor")
public class SensorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long sensor_id;

    @Column(name = "name")
    private String name;

    @Column(name = "location")
    private String location;

    @Column(name = "isActive")
    private Boolean isActive;

    @Column(name = "type")
    private String type;

    @JsonIgnore
    @OneToMany(mappedBy = "sensorEntity", cascade = CascadeType.ALL)
    private List<MeasurementEntity> measurementEntities = new ArrayList<>();

    public SensorEntity() {
    }     // default constructor for JPA

    public SensorEntity(String name, String location, Boolean isActive, String type) {
        this.name = name;
        this.location = location;
        this.isActive = isActive;
        this.type = type;
    }
}
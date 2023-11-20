/**
 * SensorController class for managing operations related to sensors and their measurements.
 * Uses Spring's RestController annotation to handle HTTP requests.
 * <p>
 * This class provides endpoints for:
 * - Retrieving all sensors
 * - Retrieving a sensor by its ID
 * - Saving a new sensor
 * - Updating an existing sensor
 * - Deleting a sensor by its ID
 * - Retrieving all measurements associated with a specific sensor
 * <p>
 * Utilizes Swagger annotations for API documentation.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 16.11.2023
 * @package: org.lecture.controller
 **/

package org.lecture.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.lecture.entity.MeasurementEntity;
import org.lecture.entity.SensorEntity;
import org.lecture.interfaces.SensorService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/sensor")
public class SensorController {
    private final SensorService sensorService;

    public SensorController(SensorService sensorService) {
        this.sensorService = sensorService;
    }

    /**
     * Retrieves a list of all sensors.
     * @return List of SensorEntity representing all sensors.
     */
    @Operation(summary = "Get all sensors")
    @GetMapping
    public List<SensorEntity> findAllSensors() {
        return sensorService.findAllSensors();
    }

    /**
     * Retrieves a sensor by its ID.
     * @param sensor_id The ID of the sensor to retrieve.
     * @return Optional containing the SensorEntity if found, empty otherwise.
     */
    @Operation(summary = "Get sensor by ID")
    @GetMapping("/{sensorId}")
    public Optional<SensorEntity> findSensorById(@PathVariable("sensorId") Long sensor_id) {
        return sensorService.findSensorById(sensor_id);
    }

    /**
     * Saves a new sensor.
     * @param sensorEntity The SensorEntity to be saved.
     * @return The saved SensorEntity.
     */
    @Operation(summary = "Save new sensor")
    @PostMapping
    public SensorEntity saveSensor(@RequestBody SensorEntity sensorEntity) {
        return sensorService.saveSensor(sensorEntity);
    }

    /**
     * Updates an existing sensor.
     * @param sensor_id The id of the sensor to be updated
     * @param sensorEntity The SensorEntity with updated information.
     */
    @Operation(summary = "Update sensor")
    @PutMapping("/{sensorId}")
    public void updateSensor(@PathVariable("sensorId") Long sensor_id, @RequestBody SensorEntity sensorEntity) {
        sensorService.updateSensor(sensor_id, sensorEntity);
    }

    /**
     * Deletes a sensor by its ID.
     * @param sensor_id The ID of the sensor to be deleted.
     */
    @Operation(summary = "Delete sensor")
    @DeleteMapping("/{sensorId}")
    public void deleteSensor(@PathVariable("sensorId") Long sensor_id) {
        sensorService.deleteSensor(sensor_id);
    }

    /**
     * Retrieves all measurements associated with a specific sensor.
     * @param sensor_id The ID of the sensor for which measurements are requested.
     * @return List of MeasurementEntity representing all measurements for the specified sensor.
     */
    @GetMapping("/{sensorId}/measurements")
    public List<MeasurementEntity> showAllMeasurementsBySensorId(@PathVariable("sensorId") Long sensor_id) {
        return sensorService.showAllMeasurementsBySensorId(sensor_id);
    }
}

/**
 * MeasurementController class for managing operations related to measurements and their associated sensors.
 * Uses Spring's RestController annotation to handle HTTP requests.
 * <p>
 * This class provides endpoints for:
 * - Retrieving all measurements
 * - Retrieving a measurement by its ID
 * - Saving a new measurement for a specified sensor
 * - Updating an existing measurement
 * - Deleting a measurement by its ID
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
import org.lecture.interfaces.MeasurementService;
import org.lecture.interfaces.SensorService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RefreshScope
@RestController
@RequestMapping("/measurement")
public class MeasurementController {

    private final SensorService sensorService;

    private final MeasurementService measurementService;

    public MeasurementController(SensorService sensorService, MeasurementService measurementService) {
        this.sensorService = sensorService;
        this.measurementService = measurementService;
    }

    /**
     * Retrieves a list of all measurements.
     * @return List of MeasurementEntity representing all measurements.
     */
    @Operation(summary = "Get all measurements")
    @GetMapping
    public List<MeasurementEntity> findAllMeasurements() {
        return measurementService.findAllMeasurements();
    }

    /**
     * Retrieves a measurement by its ID.
     * @param measurement_id The ID of the measurement to retrieve.
     * @return Optional containing the MeasurementEntity if found, empty otherwise.
     */
    @Operation(summary = "Find measurement by ID")
    @GetMapping("/{measurementId}")
    public Optional<MeasurementEntity> findMeasurementById(@PathVariable("measurementId") Long measurement_id) {
        return measurementService.findMeasurementById(measurement_id);
    }

    /**
     * Saves a new measurement for a specified sensor.
     * @param sensorId The ID of the sensor for which the measurement is associated.
     * @param measurementEntity The MeasurementEntity to be saved.
     * @return The saved MeasurementEntity.
     * @throws RuntimeException if the associated sensor is not found.
     */
    @Operation(summary = "Add new measurement")
    @PostMapping("/{sensorId}")
    public MeasurementEntity saveMeasurement(
            @PathVariable("sensorId") Long sensorId,
            @RequestBody MeasurementEntity measurementEntity) {

        SensorEntity sensor = sensorService.findSensorById(sensorId)
                .orElseThrow(() -> new RuntimeException("Sensor with ID " + sensorId + " NOT FOUND!"));

        return measurementService.saveMeasurement(sensor, measurementEntity);
    }

    /**
     * Updates an existing measurement.
     * @param measurementEntity The MeasurementEntity with updated information.
     * @return The updated MeasurementEntity.
     */
    @Operation(summary = "Update measurement")
    @PutMapping("/{measurementId}")
    public void updateMeasurement(@PathVariable("measurementId") Long measurement_id, @RequestBody MeasurementEntity measurementEntity) {
        measurementService.updateMeasurement(measurement_id, measurementEntity);
    }

    /**
     * Deletes a measurement by its ID.
     * @param measurement_id The ID of the measurement to be deleted.
     */
    @Operation(summary = "Delete measurement")
    @DeleteMapping("/{id}")
    public void deleteMeasurement(@PathVariable("id") Long measurement_id) {
        measurementService.deleteMeasurement(measurement_id);
    }
}

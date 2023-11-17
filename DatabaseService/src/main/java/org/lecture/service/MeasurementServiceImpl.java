/**
 * Service implementation class for managing operations related to measurements.
 * Implements the MeasurementService interface and provides the business logic for measurement-related operations.
 * <p>
 * This class is marked as a Spring Service using the @Service annotation.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 16.11.2023
 * @package: org.lecture.service
 **/

package org.lecture.service;

import org.lecture.entity.MeasurementEntity;
import org.lecture.entity.SensorEntity;
import org.lecture.repository.MeasurementRepository;
import org.lecture.repository.SensorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementServiceImpl implements MeasurementService {

    private final MeasurementRepository measurementRepository;

    private final SensorRepository sensorRepository;

    public MeasurementServiceImpl(MeasurementRepository measurementRepository, SensorRepository sensorRepository) {
        this.measurementRepository = measurementRepository;
        this.sensorRepository = sensorRepository;
    }

    /**
     * Retrieves a list of all measurements.
     *
     * @return List of MeasurementEntity representing all measurements.
     */
    @Override
    public List<MeasurementEntity> findAllMeasurements() {
        return measurementRepository.findAll();
    }

    /**
     * Retrieves a measurement by its ID.
     *
     * @param measurement_id The ID of the measurement to retrieve.
     * @return Optional containing the MeasurementEntity if found, empty otherwise.
     */
    @Override
    public Optional<MeasurementEntity> findMeasurementById(Long measurement_id) {
        return measurementRepository.findById(measurement_id);
    }

    /**
     * Saves a new measurement for a specified sensor.
     *
     * @param sensorEntity      The SensorEntity associated with the measurement.
     * @param measurementEntity The MeasurementEntity to be saved.
     * @return The saved MeasurementEntity.
     * @throws RuntimeException if the associated sensor is not found.
     */
    @Override
    public MeasurementEntity saveMeasurement(SensorEntity sensorEntity, MeasurementEntity measurementEntity) {
        SensorEntity existingSensor = sensorRepository.findById(sensorEntity.getSensor_id())
                .orElseThrow(() -> new RuntimeException("Sensor with ID " + sensorEntity.getSensor_id() + " NOT FOUND!"));

        measurementEntity.setSensor(existingSensor);

        return measurementRepository.save(measurementEntity);
    }


    /**
     * Updates an existing measurement.
     *
     * @param measurementEntity The MeasurementEntity with updated information.
     * @return The updated MeasurementEntity.
     * @throws RuntimeException if the measurement with the given ID is not found.
     */
    @Override
    public MeasurementEntity updateMeasurement(MeasurementEntity measurementEntity) {
        Optional<MeasurementEntity> checkExistingMeasurement = findMeasurementById(measurementEntity.getMeasurement_id());
        if (!checkExistingMeasurement.isPresent()) {
            throw new RuntimeException("Measurement with ID " + measurementEntity.getMeasurement_id() + " NOT FOUND!");
        }

        return measurementRepository.save(measurementEntity);
    }

    /**
     * Deletes a measurement by its ID.
     *
     * @param measurement_id The ID of the measurement to be deleted.
     * @throws RuntimeException if the measurement with the given ID is not found.
     */
    @Override
    public void deleteMeasurement(Long measurement_id) {
        Optional<MeasurementEntity> checkExistingMeasurement = findMeasurementById(measurement_id);
        if (!checkExistingMeasurement.isPresent()) {
            throw new RuntimeException("Measurement with ID " + measurement_id + " NOT FOUND!");
        }
        measurementRepository.deleteById(measurement_id);
    }

}

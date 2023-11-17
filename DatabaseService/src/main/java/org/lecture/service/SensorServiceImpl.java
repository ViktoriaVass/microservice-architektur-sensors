/**
 * Service implementation class for managing operations related to sensors.
 * Implements the SensorService interface and provides the business logic for sensor-related operations.
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
public class SensorServiceImpl implements SensorService {

    private final SensorRepository sensorRepository;

    public SensorServiceImpl(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    /**
     * Retrieves a list of all sensors.
     *
     * @return List of SensorEntity representing all sensors.
     */
    @Override
    public List<SensorEntity> findAllSensors() {
        return sensorRepository.findAll();
    }

    /**
     * Retrieves a sensor by its ID.
     *
     * @param sensor_id The ID of the sensor to retrieve.
     * @return Optional containing the SensorEntity if found, empty otherwise.
     */
    @Override
    public Optional<SensorEntity> findSensorById(Long sensor_id) {
        return sensorRepository.findById(sensor_id);
    }

    /**
     * Saves a new sensor.
     *
     * @param sensorEntity The SensorEntity to be saved.
     * @return The saved SensorEntity.
     */
    @Override
    public SensorEntity saveSensor(SensorEntity sensorEntity) {
        return sensorRepository.save(sensorEntity);
    }

    /**
     * Updates an existing sensor.
     *
     * @param sensro_id           The ID of the sensor to be updated.
     * @param sensorEntity The SensorEntity with updated information.
     * @throws RuntimeException if the sensor with the given ID is not found.
     */
    @Override
    public void updateSensor(Long sensro_id, SensorEntity sensorEntity) {
        Optional<SensorEntity> checkExistingSensor = findSensorById(sensorEntity.getSensor_id());
        if (!checkExistingSensor.isPresent()) {
            throw new RuntimeException("Sensor with ID " + sensorEntity.getSensor_id() + " NOT FOUND!");
        }
        sensorRepository.getReferenceById(sensro_id).setName(sensorEntity.getName());
        sensorRepository.getReferenceById(sensro_id).setLocation(sensorEntity.getLocation());
        sensorRepository.getReferenceById(sensro_id).setType(sensorEntity.getType());
        sensorRepository.getReferenceById(sensro_id).setIsActive(sensorEntity.getIsActive());
    }

    /**
     * Deletes a sensor by its ID.
     *
     * @param sensor_id The ID of the sensor to be deleted.
     * @throws RuntimeException if the sensor with the given ID is not found.
     */
    @Override
    public void deleteSensor(Long sensor_id) {
        Optional<SensorEntity> checkExistingSensor = findSensorById(sensor_id);
        if (!checkExistingSensor.isPresent()) {
            throw new RuntimeException("Sensor with ID " + sensor_id + " NOT FOUND!");
        }
        sensorRepository.deleteById(sensor_id);
    }

    /**
     * Retrieves all measurements associated with a specific sensor.
     *
     * @param sensor_id The ID of the sensor for which measurements are requested.
     * @return List of MeasurementEntity representing all measurements for the specified sensor.
     * @throws RuntimeException if the sensor with the given ID is not found.
     */
    @Override
    public List<MeasurementEntity> showAllMeasurementsBySensorId(Long sensor_id) {
        SensorEntity sensor = sensorRepository.findById(sensor_id)
                .orElseThrow(() -> new RuntimeException("Sensor with ID " + sensor_id + " NOT FOUND!"));

        return sensor.getMeasurementEntities();
    }
}

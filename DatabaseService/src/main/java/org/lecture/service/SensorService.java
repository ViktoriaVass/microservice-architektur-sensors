/**
 * Service interface for managing operations related to sensors.
 * Defines methods for interacting with SensorEntity objects.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 16.11.2023
 * @package: org.lecture.service
 **/

package org.lecture.service;

import org.lecture.entity.MeasurementEntity;
import org.lecture.entity.SensorEntity;

import java.util.List;
import java.util.Optional;

public interface SensorService {
    List<SensorEntity> findAllSensors();

    Optional<SensorEntity> findSensorById(Long sensor_id);

    SensorEntity saveSensor(SensorEntity sensorEntity);

    void updateSensor(Long sensor_id, SensorEntity sensorEntity);

    void deleteSensor(Long sensor_id);

    List<MeasurementEntity> showAllMeasurementsBySensorId(Long sensor_id);
}

/**
 * Service interface for managing operations related to measurements.
 * Defines methods for interacting with MeasurementEntity objects.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 16.11.2023
 * @package: org.lecture.service
 **/

package org.lecture.interfaces;

import org.lecture.entity.MeasurementEntity;
import org.lecture.entity.SensorEntity;

import java.util.List;
import java.util.Optional;

public interface MeasurementService {
    List<MeasurementEntity> findAllMeasurements();

    Optional<MeasurementEntity> findMeasurementById(Long sensorId);

    MeasurementEntity saveMeasurement(SensorEntity sensorEntity, MeasurementEntity measurementEntity);

    void updateMeasurement(Long measurement_id, MeasurementEntity measurementEntity);

    void deleteMeasurement(Long sensorId);
}

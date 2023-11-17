/**
 * Repository interface for managing database operations related to MeasurementEntity.
 * Extends Spring Data JPA's JpaRepository for basic CRUD functionality.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 10.11.2023
 * @package: org.lecture.repository
 **/

package org.lecture.repository;

import io.swagger.v3.oas.annotations.Hidden;
import org.lecture.entity.MeasurementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementEntity, Long> {
}

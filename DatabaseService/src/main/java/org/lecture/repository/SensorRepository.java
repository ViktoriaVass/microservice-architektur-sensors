/**
 * The SensorRepository interface serves a repository for managing SensorEntity entities.
 * This interface provides basic CRUD operations and additional query methods for retrieving sensors based on specific criteria.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 10.11.2023
 * @package: org.lecture.repository
 **/

package org.lecture.repository;

import io.swagger.v3.oas.annotations.Hidden;
import org.lecture.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Hidden
@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Long> {
}
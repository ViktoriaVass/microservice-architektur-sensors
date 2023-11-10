/**
 * The SensorRepository interface serves a repository for managing Sensor entities.
 * This interface provides basic CRUD operations and additional query methods for retrieving sensors based on specific criteria.
 *
 * @project: SWVS HA Microservice Architecture
 * @authors: Viktoria Vass, Linda Weidhofer
 * @date: 10.11.2023
 * @package: org.lecture
 *
 * @param <Sensor> The entity type managed by this repository.
 * @param <Long>   The type of the ID property of the entity.
 **/

package org.lecture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SensorRepository extends PagingAndSortingRepository<Sensor, Long>, CrudRepository<Sensor,Long> {
    /**
     * Retrieves a list of sensors with the specified name.
     *
     * @param name The name of the sensors to retrieve.
     * @return A list of sensors with the given name.
     */
    List<Sensor> findByName(@Param("name") String name);
}
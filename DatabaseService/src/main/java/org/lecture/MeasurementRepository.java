package org.lecture;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface MeasurementRepository extends PagingAndSortingRepository<Measurement, Long>, CrudRepository<Measurement, Long> {
    List<Measurement> findByTimestamp(@Param("timestamp") Date timestamp);
}
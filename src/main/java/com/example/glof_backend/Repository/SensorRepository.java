package com.example.glof_backend.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.glof_backend.Model.Sensor;




@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByLakeId(Long lakeId);
}

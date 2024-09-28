package com.example.glof_backend.Repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.glof_backend.Model.Alert;



public interface AlertRepository extends JpaRepository<Alert, Long> {
    List<Alert> findByLakeId(Long lakeId);
}

package com.example.glof_backend.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.glof_backend.Model.Simulation;


@Repository
public interface SimulationRepository extends JpaRepository<Simulation, Long> {
}

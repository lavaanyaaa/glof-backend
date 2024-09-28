package com.example.glof_backend.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.glof_backend.Model.Simulation;
import com.example.glof_backend.Repository.SimulationRepository;


@Service
public class SimulationService {

    @Autowired
    private SimulationRepository simulationRepository;

    public Simulation runSimulation(Long lakeId, String scenario, double customParams) {
        // Placeholder for integration with HEC-RAS or other simulation engines
        Simulation simulation = new Simulation();
        simulation.setId(lakeId);
        simulation.setScenario(scenario);
        simulation.setPredictedWaterLevel(customParams * 1.5); // Mock calculation
        simulation.setPredictedFloodImpact(simulation.getPredictedWaterLevel() * 2); // Mock calculation
        simulation.setRiskLevel(simulation.getPredictedFloodImpact() > 100 ? "high" : "medium");
        return simulationRepository.save(simulation);
    }
}


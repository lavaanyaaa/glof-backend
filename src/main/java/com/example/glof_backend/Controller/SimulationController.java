package com.example.glof_backend.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.glof_backend.Model.Simulation;
import com.example.glof_backend.Service.SimulationService;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/simulations")
public class SimulationController {

    @Autowired
    private SimulationService simulationService;

    @PostMapping("/{lakeId}")
    public Simulation runSimulation(@PathVariable Long lakeId, @RequestParam String scenario, @RequestParam double customParams) {
        return simulationService.runSimulation(lakeId, scenario, customParams);
    }
}


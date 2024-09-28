package com.example.glof_backend.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.glof_backend.Model.Sensor;
import com.example.glof_backend.Repository.SensorRepository;

import jakarta.persistence.EntityNotFoundException;



@Service
public class SensorService {

    @Autowired
    private SensorRepository sensorRepository;

    public List<Sensor> getSensorsByLake(Long lakeId) {
        return sensorRepository.findByLakeId(lakeId);
    }

    public Sensor updateSensor(Long sensorId, double currentValue) {
        Sensor sensor = sensorRepository.findById(sensorId).orElseThrow(() -> new EntityNotFoundException("Sensor not found"));
        sensor.setCurrentValue(currentValue);
        updateSensorStatus(sensor); // updates status based on value
        return sensorRepository.save(sensor);
    }

    private void updateSensorStatus(Sensor sensor) {
        // Simple anomaly detection based on predefined thresholds
        if (sensor.getCurrentValue() > 80) {
            sensor.setStatus("red");
        } else if (sensor.getCurrentValue() > 50) {
            sensor.setStatus("yellow");
        } else {
            sensor.setStatus("green");
        }
    }
}

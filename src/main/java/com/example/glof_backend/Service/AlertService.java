package com.example.glof_backend.Service;



import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.glof_backend.Model.Alert;
import com.example.glof_backend.Model.GlacialLake;
import com.example.glof_backend.Repository.AlertRepository;


@Service
public class AlertService {

    @Autowired
    private AlertRepository alertRepository;

    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }

    public List<Alert> getAlertsByLake(Long lakeId) {
        return alertRepository.findByLakeId(lakeId);
    }

    public Alert createAlert(GlacialLake lake, String type, String severity, String message) {
        Alert alert = new Alert();
        alert.setLake(lake);
        alert.setType(type);
        alert.setSeverity(severity);
        alert.setMessage(message);
        alert.setTimestamp(LocalDateTime.now());
        return alertRepository.save(alert);
    }

    public Alert createAlert(Alert alert) {
        if (alert.getTimestamp() == null) {
            alert.setTimestamp(LocalDateTime.now());
        }
        return alertRepository.save(alert);
    }

}

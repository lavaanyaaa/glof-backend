package com.example.glof_backend.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Sensor {

  

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public double getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(double currentValue) {
		this.currentValue = currentValue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public GlacialLake getLake() {
		return lake;
	}

	public void setLake(GlacialLake lake) {
		this.lake = lake;
	}

	private String type; // e.g., temperature, water level, dam stability
    private double currentValue;
    private String status; // green, yellow, red based on risk level

    @ManyToOne
    @JoinColumn(name = "lake_id")
    private GlacialLake lake; // which lake this sensor is monitoring

    // Getters and Setters
}
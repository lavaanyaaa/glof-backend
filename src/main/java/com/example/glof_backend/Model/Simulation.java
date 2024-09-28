package com.example.glof_backend.Model;


import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Simulation {

   
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getScenario() {
		return scenario;
	}

	public void setScenario(String scenario) {
		this.scenario = scenario;
	}

	public double getPredictedWaterLevel() {
		return predictedWaterLevel;
	}

	public void setPredictedWaterLevel(double predictedWaterLevel) {
		this.predictedWaterLevel = predictedWaterLevel;
	}

	public double getPredictedFloodImpact() {
		return predictedFloodImpact;
	}

	public void setPredictedFloodImpact(double predictedFloodImpact) {
		this.predictedFloodImpact = predictedFloodImpact;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public GlacialLake getLake() {
		return lake;
	}

	public void setLake(GlacialLake lake) {
		this.lake = lake;
	}

	private String scenario; // predefined or custom
    private double predictedWaterLevel;
    private double predictedFloodImpact;
    private String riskLevel;

    @ManyToOne
    @JoinColumn(name = "lake_id")
    private GlacialLake lake;

    // Getters and Setters
}
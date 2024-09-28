package com.example.glof_backend.Model;

import jakarta.persistence.*;

@Entity
public class GlacialLake {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getArea() {
		return area;
	}
	public void setArea(Double area) {
		this.area = area;
	}
	public Double getWater_level() {
		return water_level;
	}
	public void setWater_level(Double water_level) {
		this.water_level = water_level;
	}
	public Double getTemperature() {
		return temperature;
	}
	public void setTemperature(Double temperature) {
		this.temperature = temperature;
	}
	public String getSafety_level() {
		return safety_level;
	}
	public void setSafety_level(String safety_level) {
		this.safety_level = safety_level;
	}
	private String name;
    private Double latitude;
    private Double longitude;
    private Double area;
    private Double water_level;
    private Double temperature;
    private String safety_level; 


    
}

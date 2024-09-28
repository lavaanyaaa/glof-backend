package com.example.glof_backend.Model;



import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Alert {

   

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

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public GlacialLake getLake() {
		return lake;
	}

	public void setLake(GlacialLake lake) {
		this.lake = lake;
	}

	private String type; // e.g., flood risk, sensor anomaly
    private String severity; // low, medium, high
    private String message;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "lake_id")
    private GlacialLake lake;

    // Getters and Setters
}

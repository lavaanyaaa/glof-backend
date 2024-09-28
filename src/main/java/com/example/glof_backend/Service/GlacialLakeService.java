package com.example.glof_backend.Service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.glof_backend.Model.GlacialLake;
import com.example.glof_backend.Repository.GlacialLakeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class GlacialLakeService {

    @Autowired
    private GlacialLakeRepository glacialLakeRepository;

    public List<GlacialLake> getAllLakes() {
        return glacialLakeRepository.findAll();
    }

    public GlacialLake getLakeById(Long id) {
        return glacialLakeRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Lake not found"));
    }

    public List<GlacialLake> getLakesByRegion(double latStart, double latEnd, double lonStart, double lonEnd) {
        // Logic for retrieving lakes by region (possibly a custom query in the repository)
        return glacialLakeRepository.findByLatitudeBetweenAndLongitudeBetween(latStart, latEnd, lonStart, lonEnd);
    }

    // New method to save a GlacialLake object
    public GlacialLake saveLake(GlacialLake lake) {
        return glacialLakeRepository.save(lake);  // Persists the data into the database
    }
}

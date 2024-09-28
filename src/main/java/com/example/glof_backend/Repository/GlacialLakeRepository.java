package com.example.glof_backend.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.glof_backend.Model.GlacialLake;

public interface GlacialLakeRepository extends JpaRepository<GlacialLake, Long> {
    // Custom query for retrieving lakes within a region (optional)
    List<GlacialLake> findByLatitudeBetweenAndLongitudeBetween(double latStart, double latEnd, double lonStart, double lonEnd);
}

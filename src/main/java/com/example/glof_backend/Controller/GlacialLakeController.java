package com.example.glof_backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.glof_backend.Model.GlacialLake;
import com.example.glof_backend.Service.GlacialLakeService;



@RestController
@CrossOrigin("*")
@RequestMapping("/api/lakes")
public class GlacialLakeController {

    @Autowired
    private GlacialLakeService glacialLakeService;

    @GetMapping
    public List<GlacialLake> getAllLakes() {
        return glacialLakeService.getAllLakes();
    }

    @GetMapping("/{id}")
    public GlacialLake getLakeById(@PathVariable Long id) {
        return glacialLakeService.getLakeById(id);
    }

    @GetMapping("/region")
    public List<GlacialLake> getLakesByRegion(@RequestParam double latStart, @RequestParam double latEnd,
                                              @RequestParam double lonStart, @RequestParam double lonEnd) {
        return glacialLakeService.getLakesByRegion(latStart, latEnd, lonStart, lonEnd);
    }

    // New POST method to insert data
    @PostMapping
    public GlacialLake createLake(@RequestBody GlacialLake lake) {
        return glacialLakeService.saveLake(lake);  // This calls the service layer to save the lake
    }
}

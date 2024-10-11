package com.fitness_social.measurement_microservice.controllers;

import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    @GetMapping
    public ResponseEntity<GetMeasurementDto> getMeasurement(Long id){
        return null;
    }
    @PostMapping
    public ResponseEntity<GetMeasurementDto> createMeasurement(CreateMeasurementDto createMeasurementDto){
        return null;
    }
    @DeleteMapping
    public ResponseEntity<GetMeasurementDto> deleteMeasurement(Long id){
        return null;
    }
}

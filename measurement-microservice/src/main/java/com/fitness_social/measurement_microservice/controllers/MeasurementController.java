package com.fitness_social.measurement_microservice.controllers;

import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;
import com.fitness_social.measurement_microservice.services.IMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/measurements")
public class MeasurementController {
    @Autowired
    private IMeasurementService measurementService;
    @GetMapping
    public ResponseEntity<GetMeasurementDto> getMeasurementById(Long id){
        measurementService.getMeasurementById(id);
        return null;
    }
    @PostMapping
    public ResponseEntity<GetMeasurementDto> createMeasurement(CreateMeasurementDto createMeasurementDto){
        measurementService.createMeasurement(createMeasurementDto);
        return null;
    }
    @DeleteMapping
    public ResponseEntity<GetMeasurementDto> deleteMeasurement(Long id){
        measurementService.deleteMeasurement(id);
        return null;
    }
}

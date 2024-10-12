package com.fitness_social.measurement_microservice.services;

import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;

import java.util.List;

public interface IMeasurementService {
    GetMeasurementDto createMeasurement(CreateMeasurementDto createMeasurementDto);
    GetMeasurementDto getMeasurementById(Long id);
    List<GetMeasurementDto> getMeasurementsByOwnerUid(Long id);
    boolean deleteMeasurement(Long id);

}

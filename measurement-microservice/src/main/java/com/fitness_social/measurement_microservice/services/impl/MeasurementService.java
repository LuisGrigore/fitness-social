package com.fitness_social.measurement_microservice.services.impl;

import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;
import com.fitness_social.measurement_microservice.services.IMeasurementService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasurementService implements IMeasurementService {
    @Override
    public GetMeasurementDto createMeasurement(CreateMeasurementDto createMeasurementDto) {
        return null;
    }

    @Override
    public GetMeasurementDto getMeasurementById(Long id) {
        return null;
    }

    @Override
    public List<GetMeasurementDto> getMeasurementsByOwnerUid(Long id) {
        return null;
    }

    @Override
    public boolean deleteMeasurement(Long id) {
        return false;
    }
}

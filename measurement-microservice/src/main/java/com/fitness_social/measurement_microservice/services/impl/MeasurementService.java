package com.fitness_social.measurement_microservice.services.impl;

import com.fitness_social.measurement_microservice.domain.MeasurementEntity;
import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;
import com.fitness_social.measurement_microservice.mappers.IMeasurementMapper;
import com.fitness_social.measurement_microservice.repos.IMeasurementRepos;
import com.fitness_social.measurement_microservice.services.IMeasurementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService implements IMeasurementService {
    @Autowired
    private IMeasurementRepos measurementRepos;
    @Autowired
    private IMeasurementMapper measurementMapper;
    @Override
    public GetMeasurementDto createMeasurement(CreateMeasurementDto createMeasurementDto) {
        MeasurementEntity measurementEntity = measurementMapper.createMeasurementDtoToMeasurementEntity(createMeasurementDto);
        return measurementMapper.measurementEntityToGetMeasurementDto(measurementRepos.save(measurementEntity));
    }

    @Override
    public GetMeasurementDto getMeasurementById(Long id) {
        Optional<MeasurementEntity> measurementEntityOptional = measurementRepos.findById(id);
        return measurementEntityOptional.map(measurementEntity -> measurementMapper.measurementEntityToGetMeasurementDto(measurementEntity)).orElse(null);
    }

    @Override
    public List<GetMeasurementDto> getMeasurementsByOwnerUid(Long id) {
        return null;
    }

    @Override
    public boolean deleteMeasurement(Long id) {
        if(measurementRepos.findById(id).isEmpty()) return false;
        measurementRepos.deleteById(id);
        return true;
    }
}

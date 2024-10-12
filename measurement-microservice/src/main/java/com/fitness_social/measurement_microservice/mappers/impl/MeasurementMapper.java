package com.fitness_social.measurement_microservice.mappers.impl;

import com.fitness_social.measurement_microservice.domain.MeasurementEntity;
import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;
import com.fitness_social.measurement_microservice.mappers.IMeasurementMapper;
import org.springframework.stereotype.Component;

@Component
public class MeasurementMapper implements IMeasurementMapper {
    @Override
    public MeasurementEntity createMeasurementDtoToMeasurementEntity(CreateMeasurementDto createMeasurementDto) {
        return MeasurementEntity.builder()
                .unit(createMeasurementDto.getUnit())
                .value(createMeasurementDto.getValue())
                .type(createMeasurementDto.getType())
                .ownerUid(createMeasurementDto.getOwnerUid())
                .build();
    }

    @Override
    public GetMeasurementDto measurementEntityToGetMeasurementDto(MeasurementEntity measurementEntity) {
        return GetMeasurementDto.builder()
                .unit(measurementEntity.getUnit())
                .value(measurementEntity.getValue())
                .type(measurementEntity.getType())
                .build();
    }
}

package com.fitness_social.measurement_microservice.mappers;

import com.fitness_social.measurement_microservice.domain.MeasurementEntity;
import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;

public interface IMeasurementMapper {
    MeasurementEntity createMeasurementDtoToMeasurementEntity(CreateMeasurementDto createMeasurementDto);

    GetMeasurementDto measurementEntityToGetMeasurementDto(MeasurementEntity measurementEntity);
}

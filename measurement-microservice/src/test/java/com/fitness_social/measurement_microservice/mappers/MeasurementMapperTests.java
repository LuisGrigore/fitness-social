package com.fitness_social.measurement_microservice.mappers;

import com.fitness_social.measurement_microservice.domain.MeasurementEntity;
import com.fitness_social.measurement_microservice.domain.Type;
import com.fitness_social.measurement_microservice.domain.Unit;
import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;
import com.fitness_social.measurement_microservice.mappers.impl.MeasurementMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeasurementMapperTests {
    private final MeasurementMapper measurementMapper = new MeasurementMapper();
    @Test
    public void MeasurementMapper_CreateMeasurementDtoToMeasurementEntity_ReturnsMeasurementEntity(){
        float value = 1;
        Type type = Type.WEIGHT;
        Unit unit = Unit.UNITS;
        String ownerUid = "a";
        CreateMeasurementDto createMeasurementDto = CreateMeasurementDto.builder()
                .value(value)
                .type(type)
                .unit(unit)
                .ownerUid(ownerUid)
                .build();

        MeasurementEntity measurementEntity = measurementMapper.createMeasurementDtoToMeasurementEntity(createMeasurementDto);

        Assertions.assertThat(measurementEntity.getValue()).isEqualTo(value);
        Assertions.assertThat(measurementEntity.getType()).isEqualTo(type);
        Assertions.assertThat(measurementEntity.getUnit()).isEqualTo(unit);
        Assertions.assertThat(measurementEntity.getOwnerUid()).isEqualTo(ownerUid);
    }
    @Test
    public void MeasurementMapper_MeasurementEntityToGetMeasurementDto_ReturnsGetMeasurementDto(){
        float value = 1;
        Type type = Type.WEIGHT;
        Unit unit = Unit.UNITS;
        String ownerUid = "a";
        MeasurementEntity measurementEntity = MeasurementEntity.builder()
                .value(value)
                .type(type)
                .unit(unit)
                .ownerUid(ownerUid)
                .build();

        GetMeasurementDto getMeasurementDto = measurementMapper.measurementEntityToGetMeasurementDto(measurementEntity);

        Assertions.assertThat(getMeasurementDto.getValue()).isEqualTo(value);
        Assertions.assertThat(getMeasurementDto.getType()).isEqualTo(type);
        Assertions.assertThat(getMeasurementDto.getUnit()).isEqualTo(unit);
    }
}

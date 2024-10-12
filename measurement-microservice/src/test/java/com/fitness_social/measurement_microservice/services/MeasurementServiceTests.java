package com.fitness_social.measurement_microservice.services;

import com.fitness_social.measurement_microservice.domain.MeasurementEntity;
import com.fitness_social.measurement_microservice.dtos.CreateMeasurementDto;
import com.fitness_social.measurement_microservice.dtos.GetMeasurementDto;
import com.fitness_social.measurement_microservice.mappers.impl.MeasurementMapper;
import com.fitness_social.measurement_microservice.repos.IMeasurementRepos;
import com.fitness_social.measurement_microservice.services.impl.MeasurementService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class MeasurementServiceTests {
    @Mock
    private IMeasurementRepos measurementRepos;
    @Mock
    private MeasurementMapper measurementMapper;
    @InjectMocks
    private MeasurementService measurementService;
    @Test
    public void MeasurementService_CreateMeasuremet_Returns_GetMeasurementDto(){
        CreateMeasurementDto createMeasurementDto = new CreateMeasurementDto();
        MeasurementEntity measurementEntity = new MeasurementEntity();
        GetMeasurementDto getMeasurementDto = new GetMeasurementDto();

        when(measurementRepos.save(Mockito.any(MeasurementEntity.class))).thenReturn(measurementEntity);
        when(measurementMapper.createMeasurementDtoToMeasurementEntity(Mockito.any(CreateMeasurementDto.class))).thenReturn(measurementEntity);
        when(measurementMapper.measurementEntityToGetMeasurementDto(Mockito.any(MeasurementEntity.class))).thenReturn(getMeasurementDto);

        GetMeasurementDto getMeasurementDtoFinal = measurementService.createMeasurement(createMeasurementDto);

        Assertions.assertThat(getMeasurementDtoFinal).isNotNull();
    }
    @Test
    public void MeasurementService_GetMeasuremetById_ReturnsGetMeasurementDto(){
        Optional<MeasurementEntity> measurementEntityOptional = Optional.of(new MeasurementEntity());
        GetMeasurementDto getMeasurementDto = new GetMeasurementDto();

        when(measurementRepos.findById(Mockito.any(Long.class))).thenReturn(measurementEntityOptional);
        when(measurementMapper.measurementEntityToGetMeasurementDto(Mockito.any(MeasurementEntity.class))).thenReturn(getMeasurementDto);

        GetMeasurementDto getMeasurementDtoFinal = measurementService.getMeasurementById(Mockito.any(Long.class));

        Assertions.assertThat(getMeasurementDtoFinal).isNotNull();
    }

    @Test
    public void MeasurementService_GetMeasuremetById_ReturnsNull(){
        Optional<MeasurementEntity> measurementEntityOptional = Optional.empty();

        when(measurementRepos.findById(Mockito.any(Long.class))).thenReturn(measurementEntityOptional);

        GetMeasurementDto getMeasurementDtoFinal = measurementService.getMeasurementById(Mockito.any(Long.class));

        Assertions.assertThat(getMeasurementDtoFinal).isNull();
    }

    @Test
    public void MeasurementService_DeleteById_ReturnsTrue(){
        Optional<MeasurementEntity> measurementEntityOptional = Optional.of(new MeasurementEntity());

        when(measurementRepos.findById(Mockito.any(Long.class))).thenReturn(measurementEntityOptional);

        boolean measurementDeleted = measurementService.deleteMeasurement(Mockito.any(Long.class));

        Assertions.assertThat(measurementDeleted).isTrue();
    }
    @Test
    public void MeasurementService_DeleteById_ReturnsFalse(){
        Optional<MeasurementEntity> measurementEntityOptional = Optional.empty();

        when(measurementRepos.findById(Mockito.any(Long.class))).thenReturn(measurementEntityOptional);

        boolean measurementDeleted = measurementService.deleteMeasurement(Mockito.any(Long.class));

        Assertions.assertThat(measurementDeleted).isFalse();
    }

}

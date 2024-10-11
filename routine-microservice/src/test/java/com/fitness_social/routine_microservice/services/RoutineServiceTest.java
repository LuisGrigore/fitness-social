package com.fitness_social.routine_microservice.services;

import com.fitness_social.routine_microservice.domain.RoutineEntity;
import com.fitness_social.routine_microservice.dtos.CreateRoutineDto;
import com.fitness_social.routine_microservice.dtos.GetRoutineDto;
import com.fitness_social.routine_microservice.mappers.RoutineMapper;
import com.fitness_social.routine_microservice.repos.IRoutineRepos;
import com.fitness_social.routine_microservice.services.impl.RoutineService;
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
public class RoutineServiceTest {
    @Mock
    private IRoutineRepos routineRepos;
    @Mock
    private RoutineMapper routineMapper;
    @InjectMocks
    private RoutineService routineService;

    @Test
    public void RoutineService_CreateRoutine_ReturnGetRoutineDto(){
        CreateRoutineDto createRoutineDto = new CreateRoutineDto();
        RoutineEntity routineEntity = new RoutineEntity();
        GetRoutineDto getRoutineDto = new GetRoutineDto();

        when(routineRepos.save(Mockito.any(RoutineEntity.class))).thenReturn(routineEntity);
        when(routineMapper.createRoutineDtoToRoutineEntity(Mockito.any(CreateRoutineDto.class))).thenReturn(routineEntity);
        when(routineMapper.routineEntityToGetRoutineDto(Mockito.any(RoutineEntity.class))).thenReturn(getRoutineDto);

        GetRoutineDto getRoutineDtoFinal = routineService.createRoutine(createRoutineDto);

        Assertions.assertThat(getRoutineDtoFinal).isNotNull();
    }
    @Test
    public void RoutineService_DeleteRoutine_ReturnFalse(){
        boolean userDeleted = routineService.deleteRoutine(Mockito.any(Long.class));
        Assertions.assertThat(userDeleted).isFalse();
    }
    @Test
    public void RoutineService_DeleteRoutine_ReturnTrue(){
        Optional<RoutineEntity> routineEntity = Optional.of(new RoutineEntity());

        when(routineRepos.findById(Mockito.any(Long.class))).thenReturn(routineEntity);

        boolean userDeleted = routineService.deleteRoutine(Mockito.any(Long.class));

        Assertions.assertThat(userDeleted).isTrue();
    }
}

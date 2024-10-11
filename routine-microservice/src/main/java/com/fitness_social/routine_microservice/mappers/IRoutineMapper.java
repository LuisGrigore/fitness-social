package com.fitness_social.routine_microservice.mappers;

import com.fitness_social.routine_microservice.domain.RoutineEntity;
import com.fitness_social.routine_microservice.dtos.CreateRoutineDto;
import com.fitness_social.routine_microservice.dtos.GetRoutineDto;



public interface IRoutineMapper {
    RoutineEntity createRoutineDtoToRoutineEntity(CreateRoutineDto createRoutineDto);
    GetRoutineDto routineEntityToGetRoutineDto(RoutineEntity routineEntity);

}

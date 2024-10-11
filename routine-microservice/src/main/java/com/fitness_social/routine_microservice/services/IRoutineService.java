package com.fitness_social.routine_microservice.services;

import com.fitness_social.routine_microservice.dtos.CreateRoutineDto;
import com.fitness_social.routine_microservice.dtos.GetRoutineDto;
import org.springframework.http.ResponseEntity;

public interface IRoutineService {
    GetRoutineDto createRoutine(CreateRoutineDto createRoutineDto);

    boolean deleteRoutine(Long id);
}

package com.fitness_social.exercise_microservice.services.impl;

import com.fitness_social.exercise_microservice.domain.ExerciseEntity;
import com.fitness_social.exercise_microservice.domain.RoutineExerciseEntity;
import com.fitness_social.exercise_microservice.dtos.AddExerciseToRoutineDto;
import com.fitness_social.exercise_microservice.dtos.GetRoutineExerciseDto;
import com.fitness_social.exercise_microservice.repos.IRoutineExerciseRepos;
import com.fitness_social.exercise_microservice.services.IRoutineExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoutineExerciseService implements IRoutineExerciseService {
    @Autowired
    private IRoutineExerciseRepos routineExerciseRepos;
    @Override
    public GetRoutineExerciseDto addExerciseToRoutine(AddExerciseToRoutineDto addExerciseToRoutineDto) {
        RoutineExerciseEntity routineExerciseEntity = routineExerciseRepos.save(RoutineExerciseEntity.builder().exerciseEntity(new ExerciseEntity(addExerciseToRoutineDto.getExercise())).routineId(addExerciseToRoutineDto.getRoutine()).build());
        return new GetRoutineExerciseDto(routineExerciseEntity.getId(), routineExerciseEntity.getRoutineId(), routineExerciseEntity.getExerciseEntity().getId());
    }
}

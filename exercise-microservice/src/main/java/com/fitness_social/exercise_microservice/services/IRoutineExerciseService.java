package com.fitness_social.exercise_microservice.services;

import com.fitness_social.exercise_microservice.dtos.AddExerciseToRoutineDto;
import com.fitness_social.exercise_microservice.dtos.GetRoutineExerciseDto;

public interface IRoutineExerciseService {
    GetRoutineExerciseDto addExerciseToRoutine(AddExerciseToRoutineDto addExerciseToRoutineDto);
}

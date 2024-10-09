package com.fitness_social.exercise_microservice.services;

import com.fitness_social.exercise_microservice.dtos.CreateExerciseDto;
import com.fitness_social.exercise_microservice.dtos.GetExerciseDto;

public interface IExerciseService {
    GetExerciseDto create(CreateExerciseDto createExerciseDto);
}

package com.fitness_social.exercise_microservice.mappers;

import com.fitness_social.exercise_microservice.domain.ExerciseEntity;
import com.fitness_social.exercise_microservice.dtos.CreateExerciseDto;
import com.fitness_social.exercise_microservice.dtos.GetExerciseDto;

public interface IExerciseMapper {

    ExerciseEntity createExerciseDtoToExerciseEntity(CreateExerciseDto createExerciseDto);

    GetExerciseDto exerciseEntityToGetExerciseDto(ExerciseEntity exerciseEntity);
}

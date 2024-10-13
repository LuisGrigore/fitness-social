package com.fitness_social.exercise_microservice.mappers.impl;

import com.fitness_social.exercise_microservice.domain.ExerciseEntity;
import com.fitness_social.exercise_microservice.dtos.CreateExerciseDto;
import com.fitness_social.exercise_microservice.dtos.GetExerciseDto;
import com.fitness_social.exercise_microservice.mappers.IExerciseMapper;
import org.springframework.stereotype.Component;

@Component
public class ExerciseMapper implements IExerciseMapper {
    @Override
    public ExerciseEntity createExerciseDtoToExerciseEntity(CreateExerciseDto createExerciseDto) {
        return ExerciseEntity.builder()
                .name(createExerciseDto.getName())
                .description(createExerciseDto.getDescription())
                .build();
    }

    @Override
    public GetExerciseDto exerciseEntityToGetExerciseDto(ExerciseEntity exerciseEntity) {
        return GetExerciseDto.builder()
                .id(exerciseEntity.getId())
                .name(exerciseEntity.getName())
                .description(exerciseEntity.getDescription())
                .build();
    }
}

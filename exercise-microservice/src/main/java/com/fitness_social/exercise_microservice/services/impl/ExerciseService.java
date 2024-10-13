package com.fitness_social.exercise_microservice.services.impl;

import com.fitness_social.exercise_microservice.domain.ExerciseEntity;
import com.fitness_social.exercise_microservice.dtos.CreateExerciseDto;
import com.fitness_social.exercise_microservice.dtos.GetExerciseDto;
import com.fitness_social.exercise_microservice.mappers.IExerciseMapper;
import com.fitness_social.exercise_microservice.repos.IExerciseRepos;
import com.fitness_social.exercise_microservice.services.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService implements IExerciseService {
    @Autowired
    private IExerciseRepos exerciseRepos;
    @Autowired
    private IExerciseMapper exerciseMapper;
    @Override
    public GetExerciseDto create(CreateExerciseDto createExerciseDto) {
        ExerciseEntity exerciseEntity = exerciseRepos.save(exerciseMapper.createExerciseDtoToExerciseEntity(createExerciseDto));
        return exerciseMapper.exerciseEntityToGetExerciseDto(exerciseEntity);
    }
}

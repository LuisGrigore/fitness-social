package com.fitness_social.exercise_microservice.services.impl;

import com.fitness_social.exercise_microservice.domain.ExerciseEntity;
import com.fitness_social.exercise_microservice.dtos.CreateExerciseDto;
import com.fitness_social.exercise_microservice.dtos.GetExerciseDto;
import com.fitness_social.exercise_microservice.repos.IExerciseRepos;
import com.fitness_social.exercise_microservice.services.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExerciseService implements IExerciseService {
    @Autowired
    private IExerciseRepos repos;
    @Override
    public GetExerciseDto create(CreateExerciseDto createExerciseDto) {
        ExerciseEntity exerciseEntity = repos.save(new ExerciseEntity());
        return new GetExerciseDto(exerciseEntity.getId());
    }
}

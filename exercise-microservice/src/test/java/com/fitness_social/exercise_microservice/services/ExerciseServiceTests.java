package com.fitness_social.exercise_microservice.services;

import com.fitness_social.exercise_microservice.domain.ExerciseEntity;
import com.fitness_social.exercise_microservice.dtos.CreateExerciseDto;
import com.fitness_social.exercise_microservice.dtos.GetExerciseDto;
import com.fitness_social.exercise_microservice.mappers.impl.ExerciseMapper;
import com.fitness_social.exercise_microservice.repos.IExerciseRepos;
import com.fitness_social.exercise_microservice.services.impl.ExerciseService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExerciseServiceTests {
    @Mock
    private ExerciseMapper exerciseMapper;
    @Mock
    private IExerciseRepos exerciseRepos;
    @InjectMocks
    private ExerciseService exerciseService;

    @Test
    public void ExerciseService_CreateExercise_ReturnsGetExerciseDto(){
        CreateExerciseDto createExerciseDto = new CreateExerciseDto();
        ExerciseEntity exerciseEntity = new ExerciseEntity();
        GetExerciseDto getExerciseDto = new GetExerciseDto();

        when(exerciseMapper.createExerciseDtoToExerciseEntity(Mockito.any(CreateExerciseDto.class))).thenReturn(exerciseEntity);
        when(exerciseRepos.save(Mockito.any(ExerciseEntity.class))).thenReturn(exerciseEntity);
        when(exerciseMapper.exerciseEntityToGetExerciseDto(Mockito.any(ExerciseEntity.class))).thenReturn(getExerciseDto);


        getExerciseDto = exerciseService.create(createExerciseDto);

        Assertions.assertThat(getExerciseDto).isNotNull();
    }
}

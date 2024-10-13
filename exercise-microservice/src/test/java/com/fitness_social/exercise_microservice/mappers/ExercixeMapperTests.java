package com.fitness_social.exercise_microservice.mappers;

import com.fitness_social.exercise_microservice.domain.ExerciseEntity;
import com.fitness_social.exercise_microservice.dtos.CreateExerciseDto;
import com.fitness_social.exercise_microservice.dtos.GetExerciseDto;
import com.fitness_social.exercise_microservice.mappers.impl.ExerciseMapper;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ExercixeMapperTests {
    private final ExerciseMapper exerciseMapper = new ExerciseMapper();

    @Test
    public void ExerciseMapper_CreateExerciseDtoToExerciseEntity_ReturnsExerciseEntity(){
        String name  = Mockito.any(String.class);
        String description  = Mockito.any(String.class);
        CreateExerciseDto createExerciseDto = CreateExerciseDto.builder()
                .name(name)
                .description(description)
                .build();

        ExerciseEntity exerciseEntity = exerciseMapper.createExerciseDtoToExerciseEntity(createExerciseDto);

        Assertions.assertThat(exerciseEntity.getName()).isEqualTo(name);
        Assertions.assertThat(exerciseEntity.getDescription()).isEqualTo(description);
    }
    @Test
    public void ExerciseMapper_ExerciseEntityToGetExerciseDto_ReturnsGetExerciseDto(){
        String name  = Mockito.any(String.class);
        String description  = Mockito.any(String.class);
        ExerciseEntity exerciseEntity = ExerciseEntity.builder()
                .name(name)
                .description(description)
                .build();

        GetExerciseDto getExerciseDto = exerciseMapper.exerciseEntityToGetExerciseDto(exerciseEntity);

        Assertions.assertThat(getExerciseDto.getName()).isEqualTo(name);
        Assertions.assertThat(getExerciseDto.getDescription()).isEqualTo(description);
    }
}

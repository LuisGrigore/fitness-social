package com.fitness_social.complete_recipe_service.datasources;

import com.fitness_social.complete_recipe_service.dtos.GetExerciseDto;
import com.fitness_social.complete_recipe_service.dtos.GetRoutineDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Datasource implements IDatasource{
    @Override
    public GetExerciseDto getExercise(Long id) {
        return null;
    }

    @Override
    public List<GetExerciseDto> getExercises(List<Long> ids) {
        return null;
    }

    @Override
    public GetRoutineDto getRoutineById(Long id) {
        return null;
    }

    @Override
    public List<GetRoutineDto> getRoutinesByName(String name) {
        return null;
    }

    @Override
    public List<GetRoutineDto> getRoutinesByUser(String uid) {
        return null;
    }
}

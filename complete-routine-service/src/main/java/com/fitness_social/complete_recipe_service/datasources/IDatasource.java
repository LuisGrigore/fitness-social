package com.fitness_social.complete_recipe_service.datasources;

import com.fitness_social.complete_recipe_service.dtos.GetExerciseDto;
import com.fitness_social.complete_recipe_service.dtos.GetRoutineDto;

import java.util.List;

public interface IDatasource {
    GetExerciseDto getExercise(Long id);
    List<GetExerciseDto> getExercises(List<Long> ids);
    GetRoutineDto getRoutineById(Long id);
    List<GetRoutineDto> getRoutinesByName(String name);
    List<GetRoutineDto> getRoutinesByUser(String uid);


}

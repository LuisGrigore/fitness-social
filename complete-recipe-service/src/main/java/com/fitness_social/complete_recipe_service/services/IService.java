package com.fitness_social.complete_recipe_service.services;

import com.fitness_social.complete_recipe_service.dtos.GetCompleateRoutineDto;

import java.util.List;

public interface IService {
    GetCompleateRoutineDto getRecipeById(Long id);
    List<GetCompleateRoutineDto> getRecipesByName(String name);
    List<GetCompleateRoutineDto> getRecipesByUser(String uid);
}

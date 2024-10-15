package com.fitness_social.complete_recipe_service.services;

import com.fitness_social.complete_recipe_service.datasources.IDatasource;
import com.fitness_social.complete_recipe_service.dtos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CRoutineService implements IService{
    @Autowired
    private IDatasource datasource;
    @Override
    public GetCompleateRoutineDto getRecipeById(Long id) {
        GetRoutineDto routineDto = datasource.getRoutineById(id);
        if(routineDto == null) return null;
        List<GetExerciseDto> completeExercises = datasource.getExercises(getExercisesFromRoutine(routineDto));
        return getCompleateRoutineDto(routineDto,completeExercises);
    }

    @Override
    public List<GetCompleateRoutineDto> getRecipesByName(String name) {
        List<GetRoutineDto> routineDtos = datasource.getRoutinesByName(name);
        List<GetCompleateRoutineDto> compleateRoutineDtos = new ArrayList<>();
        for(GetRoutineDto routineDto : routineDtos){
            List<GetExerciseDto> completeExercises = datasource.getExercises(getExercisesFromRoutine(routineDto));
            compleateRoutineDtos.add(getCompleateRoutineDto(routineDto,completeExercises));
        }
        return compleateRoutineDtos;
    }

    @Override
    public List<GetCompleateRoutineDto> getRecipesByUser(String uid) {
        List<GetRoutineDto> routineDtos = datasource.getRoutinesByUser(uid);
        List<GetCompleateRoutineDto> compleateRoutineDtos = new ArrayList<>();
        for(GetRoutineDto routineDto : routineDtos){
            List<GetExerciseDto> completeExercises = datasource.getExercises(getExercisesFromRoutine(routineDto));
            compleateRoutineDtos.add(getCompleateRoutineDto(routineDto,completeExercises));
        }
        return compleateRoutineDtos;
    }

    private GetCompleateRoutineDto getCompleateRoutineDto(GetRoutineDto routineDto,List<GetExerciseDto> completeExercises){
        List<CompleteSetDto> completeSetDtos = new ArrayList<>();
        for(int i = 0; i < completeExercises.size(); i++){
            completeSetDtos.add(CompleteSetDto.builder().reps(routineDto.getSetDtoList().get(i).getReps())
                    .rest(routineDto.getSetDtoList().get(i).getRest())
                    .exercise(completeExercises.get(i)).build());
        }
        return new GetCompleateRoutineDto(routineDto.getName(), completeSetDtos);
    }
    private List<Long> getExercisesFromRoutine(GetRoutineDto routineDto){
        List<Long> exercises = new ArrayList<>();
        for (SetDto set : routineDto.getSetDtoList()){
            exercises.add(set.getExercise());
        }
        return exercises;
    }
}

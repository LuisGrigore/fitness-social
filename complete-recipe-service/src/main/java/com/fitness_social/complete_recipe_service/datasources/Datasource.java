package com.fitness_social.complete_recipe_service.datasources;

import com.fitness_social.complete_recipe_service.dtos.GetExerciseDto;
import com.fitness_social.complete_recipe_service.dtos.GetRoutineDto;
import com.fitness_social.complete_recipe_service.dtos.GetRoutinesDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class Datasource implements IDatasource{
    private final static String EXERCISE_MICROSERVICE_URL= "http://EXERCISE-MICROSERVICE";
    private final static String ROUTINE_MICROSERVICE_URL= "http://ROUTINE-MICROSERVICE";

    @Autowired
    private RestTemplate restTemplate;
    @Override
    public GetExerciseDto getExercise(Long id) {
        return restTemplate.getForObject(EXERCISE_MICROSERVICE_URL, GetExerciseDto.class);
    }

    @Override
    public List<GetExerciseDto> getExercises(List<Long> ids) {
        List<GetExerciseDto> getExerciseDtos = new ArrayList<>();
        for(Long id : ids){
            GetExerciseDto getExerciseDto = restTemplate.getForObject(EXERCISE_MICROSERVICE_URL, GetExerciseDto.class);
            if(getExerciseDto != null) getExerciseDtos.add(getExerciseDto);
        }
        return getExerciseDtos;
    }

    @Override
    public GetRoutineDto getRoutineById(Long id) {
        return restTemplate.getForObject(ROUTINE_MICROSERVICE_URL, GetRoutineDto.class);
    }

    @Override
    public List<GetRoutineDto> getRoutinesByName(String name) {
        return restTemplate.getForObject(ROUTINE_MICROSERVICE_URL, GetRoutinesDto.class).getRoutineDtos();
    }

    @Override
    public List<GetRoutineDto> getRoutinesByUser(String uid) {
        return restTemplate.getForObject(ROUTINE_MICROSERVICE_URL, GetRoutinesDto.class).getRoutineDtos();
    }
}

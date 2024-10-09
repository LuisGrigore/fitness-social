package com.fitness_social.routine_microservice.services.impl;

import com.fitness_social.routine_microservice.domain.RoutineEntity;
import com.fitness_social.routine_microservice.domain.SetEntity;
import com.fitness_social.routine_microservice.dtos.CreateRoutineDto;
import com.fitness_social.routine_microservice.dtos.CreateSetDto;
import com.fitness_social.routine_microservice.dtos.GetRoutineDto;
import com.fitness_social.routine_microservice.repos.IRoutineRepos;
import com.fitness_social.routine_microservice.repos.ISetRepos;
import com.fitness_social.routine_microservice.services.IRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoutineService implements IRoutineService {
    @Autowired
    private IRoutineRepos routineRepos;
    @Autowired
    private ISetRepos setRepos;
    @Override
    public GetRoutineDto createRoutine(CreateRoutineDto createRoutineDto) {
        List<SetEntity> setEntities = new ArrayList<>();
        for(CreateSetDto createSetDto : createRoutineDto.getSets()){
            SetEntity setEntity = SetEntity.builder().rest(createSetDto.getRest()).reps(createSetDto.getReps()).build();
            setEntities.add(setRepos.save(setEntity));
        }
        RoutineEntity routineEntity = RoutineEntity.builder().name(createRoutineDto.getName()).sets(setEntities).build();
        routineEntity = routineRepos.save(routineEntity);
        return GetRoutineDto.builder().name(routineEntity.getName()).build();
    }
}

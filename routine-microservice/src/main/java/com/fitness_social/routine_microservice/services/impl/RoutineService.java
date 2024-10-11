package com.fitness_social.routine_microservice.services.impl;

import com.fitness_social.routine_microservice.domain.RoutineEntity;
import com.fitness_social.routine_microservice.dtos.CreateRoutineDto;
import com.fitness_social.routine_microservice.dtos.GetRoutineDto;
import com.fitness_social.routine_microservice.mappers.IRoutineMapper;
import com.fitness_social.routine_microservice.repos.IRoutineRepos;
import com.fitness_social.routine_microservice.repos.ISetRepos;
import com.fitness_social.routine_microservice.services.IRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class RoutineService implements IRoutineService {
    @Autowired
    private IRoutineRepos routineRepos;
    @Autowired
    private ISetRepos setRepos;
    @Autowired
    private IRoutineMapper routineMapper;
    @Override
    public GetRoutineDto createRoutine(CreateRoutineDto createRoutineDto) {
        RoutineEntity routineEntity = routineRepos.save(routineMapper.createRoutineDtoToRoutineEntity(createRoutineDto));
        return routineMapper.routineEntityToGetRoutineDto(routineEntity);
    }
    @Override
    public boolean deleteRoutine(Long id) {
        if(routineRepos.findById(id).isEmpty()) return false;
        routineRepos.deleteById(id);
        return true;
    }
}

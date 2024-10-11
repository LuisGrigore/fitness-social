package com.fitness_social.routine_microservice.mappers.impl;

import com.fitness_social.routine_microservice.domain.RoutineEntity;
import com.fitness_social.routine_microservice.domain.SetEntity;
import com.fitness_social.routine_microservice.dtos.CreateRoutineDto;
import com.fitness_social.routine_microservice.dtos.CreateSetDto;
import com.fitness_social.routine_microservice.dtos.GetRoutineDto;
import com.fitness_social.routine_microservice.dtos.GetSetDto;
import com.fitness_social.routine_microservice.mappers.IRoutineMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RoutineMapper implements IRoutineMapper {

    @Override
    public RoutineEntity createRoutineDtoToRoutineEntity(CreateRoutineDto createRoutineDto){
        return RoutineEntity.builder()
                .name(createRoutineDto.getName())
                .description(createRoutineDto.getDescription())
                .ownerUid(createRoutineDto.getOwnerUid())
                .sets(getSetEntitiesFromCreateSetDtos(createRoutineDto.getSets()))
                .build();
    }
    private List<SetEntity> getSetEntitiesFromCreateSetDtos(List<CreateSetDto> createSetDtos){
        if(createSetDtos == null || createSetDtos.isEmpty()) return null;
        List<SetEntity> setEntities = new ArrayList<>();
        for(CreateSetDto createSetDto : createSetDtos){
            SetEntity setEntity = SetEntity.builder()
                    .rest(createSetDto.getRest())
                    .reps(createSetDto.getReps())
                    .exerciseId(createSetDto.getExerciseId())
                    .build();
            setEntities.add(setEntity);
        }
        return setEntities;
    }
    @Override
    public GetRoutineDto routineEntityToGetRoutineDto(RoutineEntity routineEntity){
            return GetRoutineDto.builder()
                    .name(routineEntity.getName())
                    .description(routineEntity.getDescription())
                    .sets(getSetDtosFromSetEntities(routineEntity.getSets()))
                    .build();
    }
    private List<GetSetDto> getSetDtosFromSetEntities(List<SetEntity> setEntities){
        if(setEntities == null || setEntities.isEmpty()) return null;
        List<GetSetDto> setDtos = new ArrayList<>();
        for(SetEntity setEntity : setEntities){
            GetSetDto getSetDto = GetSetDto.builder()
                    .rest(setEntity.getRest())
                    .reps(setEntity.getReps())
                    .exerciseId(setEntity.getExerciseId())
                    .build();
            setDtos.add(getSetDto);
        }
        return setDtos;
    }
}

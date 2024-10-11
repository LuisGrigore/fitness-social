package com.fitness_social.routine_microservice.mappers;

import com.fitness_social.routine_microservice.domain.RoutineEntity;
import com.fitness_social.routine_microservice.dtos.CreateRoutineDto;
import com.fitness_social.routine_microservice.dtos.CreateSetDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RoutineMapperTest {
    private final RoutineMapper routineMapper = new RoutineMapper();

    @Test
    public void RoutineMapper_CreateRoutineDtoToRoutineEntity_ReturnUserEntityWithNullSets(){
        String name = "a";
        String ownerUid = "aa";
        String description = "aaa";
        List<CreateSetDto> createSetDtos = null;
        CreateRoutineDto createRoutineDto = CreateRoutineDto.builder()
                .name(name)
                .ownerUid(ownerUid)
                .description(description)
                .sets(createSetDtos)
                .build();

        RoutineEntity routineEntity = routineMapper.createRoutineDtoToRoutineEntity(createRoutineDto);

        Assertions.assertThat(routineEntity.getName()).isEqualTo(name);
        Assertions.assertThat(routineEntity.getOwnerUid()).isEqualTo(ownerUid);
        Assertions.assertThat(routineEntity.getDescription()).isEqualTo(description);
        Assertions.assertThat(routineEntity.getSets()).isNull();
    }
    @Test
    public void RoutineMapper_CreateRoutineDtoToRoutineEntity_ReturnUserEntity(){
        String name = "a";
        String ownerUid = "aa";
        String description = "aaa";
        List<CreateSetDto> createSetDtos = new ArrayList<>();
        createSetDtos.add(new CreateSetDto());
        createSetDtos.add(new CreateSetDto());
        CreateRoutineDto createRoutineDto = CreateRoutineDto.builder()
                .name(name)
                .ownerUid(ownerUid)
                .description(description)
                .sets(createSetDtos)
                .build();

        RoutineEntity routineEntity = routineMapper.createRoutineDtoToRoutineEntity(createRoutineDto);

        Assertions.assertThat(routineEntity.getName()).isEqualTo(name);
        Assertions.assertThat(routineEntity.getOwnerUid()).isEqualTo(ownerUid);
        Assertions.assertThat(routineEntity.getDescription()).isEqualTo(description);
        Assertions.assertThat(routineEntity.getSets()).isNotNull();
    }

}

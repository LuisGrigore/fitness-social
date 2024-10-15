package com.fitness_social.complete_recipe_service.services;

import com.fitness_social.complete_recipe_service.datasources.Datasource;
import com.fitness_social.complete_recipe_service.dtos.GetExerciseDto;
import com.fitness_social.complete_recipe_service.dtos.GetRoutineDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class CRoutineServiceTests {
    @Mock
    private Datasource datasource;
    @InjectMocks
    private CRoutineService cRoutineService;

    @Test
    public void CRoutineService_GetRecipeById_ReturnsGetCompleateRoutineDto(){
        GetRoutineDto getRoutineDto = new GetRoutineDto();
        List<GetExerciseDto> getExerciseDtoList = new ArrayList<>();

        when(datasource.getRoutineById(Mockito.any(Long.class))).thenReturn(getRoutineDto);
        when(datasource.getExercises(Mockito.anyList())).thenReturn(getExerciseDtoList);

        Assertions.assertThat(cRoutineService.getRecipeById(Mockito.any(Long.class))).isNotNull();
    }

    @Test
    public void CRoutineService_GetRecipeById_ReturnsNull(){
        when(datasource.getRoutineById(Mockito.any(Long.class))).thenReturn(null);

        Assertions.assertThat(cRoutineService.getRecipeById(Mockito.any(Long.class))).isNull();
    }

    @Test
    public void CRoutineService_GetRecipeByName_ReturnsListOfGetRecipeDto(){
        List<GetRoutineDto> getRoutineDtoList = new ArrayList<>();
        List<GetExerciseDto> getExerciseDtoList = new ArrayList<>();

        when(datasource.getRoutinesByName(Mockito.any(String.class))).thenReturn(getRoutineDtoList);
        when(datasource.getExercises(Mockito.anyList())).thenReturn(getExerciseDtoList);

        Assertions.assertThat(cRoutineService.getRecipesByName(Mockito.any(String.class))).isNotNull();
    }
}

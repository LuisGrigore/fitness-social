package com.fitness_social.complete_recipe_service.datasources;

import com.fitness_social.complete_recipe_service.dtos.GetExerciseDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DatasourcesTests {
    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private Datasource datasource;

    @Test
    public void Datasource_GetExercise_ReturnsGetExerciseDto(){
        when(restTemplate.getForObject(Mockito.any(String.class),eq(GetExerciseDto.class))).thenReturn(new GetExerciseDto());

        GetExerciseDto getExerciseDto = datasource.getExercise(0L);

        Assertions.assertThat(getExerciseDto).isNotNull();
    }
    @Test
    public void Datasource_GetExercises_ReturnsGetExerciseDtos(){
        List<GetExerciseDto> getExerciseDtos = datasource.getExercises(new ArrayList<Long>());

        Assertions.assertThat(getExerciseDtos).isNotNull();
    }
}

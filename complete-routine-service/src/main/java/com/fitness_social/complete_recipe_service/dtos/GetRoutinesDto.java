package com.fitness_social.complete_recipe_service.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetRoutinesDto {
    private List<GetRoutineDto> routineDtos;
}

package com.fitness_social.complete_recipe_service.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class GetCompleateRoutineDto {
    private String name;
    private List<CompleteSetDto> sets;
}

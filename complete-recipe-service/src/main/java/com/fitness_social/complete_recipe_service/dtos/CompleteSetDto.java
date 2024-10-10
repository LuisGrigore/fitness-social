package com.fitness_social.complete_recipe_service.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CompleteSetDto {
    private int reps;
    private int rest;
    private GetExerciseDto exercise;
}

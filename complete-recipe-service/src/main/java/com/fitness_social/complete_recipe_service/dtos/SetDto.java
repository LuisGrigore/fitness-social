package com.fitness_social.complete_recipe_service.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SetDto {
    private int reps;
    private int rest;
    private Long exercise;
}

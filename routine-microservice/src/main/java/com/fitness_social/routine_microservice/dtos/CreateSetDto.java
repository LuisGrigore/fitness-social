package com.fitness_social.routine_microservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateSetDto {
    private Long exerciseId;
    private int reps;
    private int rest;
}

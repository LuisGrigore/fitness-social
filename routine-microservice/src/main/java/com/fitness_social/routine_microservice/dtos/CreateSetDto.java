package com.fitness_social.routine_microservice.dtos;

import com.fitness_social.routine_microservice.domain.RoutineEntity;
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

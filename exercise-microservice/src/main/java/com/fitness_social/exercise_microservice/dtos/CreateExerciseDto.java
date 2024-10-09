package com.fitness_social.exercise_microservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateExerciseDto {
    private String name;
}

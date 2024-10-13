package com.fitness_social.exercise_microservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetExerciseDto {
    private Long id;
    private String name;
    private String description;
}

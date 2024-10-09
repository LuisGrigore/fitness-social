package com.fitness_social.exercise_microservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AddExerciseToRoutineDto {
    private Long exercise;
    private Long routine;
}

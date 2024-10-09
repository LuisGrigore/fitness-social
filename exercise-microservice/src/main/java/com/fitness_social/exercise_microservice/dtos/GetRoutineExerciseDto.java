package com.fitness_social.exercise_microservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetRoutineExerciseDto {
    private Long id;
    private Long idRoutine;
    private Long idExercise;
}

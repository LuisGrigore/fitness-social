package com.fitness_social.exercise_microservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoutineExerciseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private ExerciseEntity exerciseEntity;
    private Long routineId;
}

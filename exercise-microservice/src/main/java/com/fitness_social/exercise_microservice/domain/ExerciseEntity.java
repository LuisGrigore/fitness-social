package com.fitness_social.exercise_microservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ExerciseEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
}

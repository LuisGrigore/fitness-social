package com.fitness_social.routine_microservice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SetEntity {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private RoutineEntity routine;
    private int reps;
    private Long exerciseId;
    private int rest;

}

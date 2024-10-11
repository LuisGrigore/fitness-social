package com.fitness_social.routine_microservice.domain;

import jakarta.persistence.*;
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
    @Column
    private int reps;
    @Column
    private Long exerciseId;
    @Column
    private int rest;
    @Column
    private float weight;

}

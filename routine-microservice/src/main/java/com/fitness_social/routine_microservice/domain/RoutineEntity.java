package com.fitness_social.routine_microservice.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RoutineEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Column(name = "owner_uid")
    private String ownerUid;
    @OneToMany
    private List<SetEntity> sets;
}

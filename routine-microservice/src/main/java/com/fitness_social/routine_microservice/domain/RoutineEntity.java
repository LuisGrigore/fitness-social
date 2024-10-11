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
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "owner_uid")
    private String ownerUid;
    @OneToMany(cascade = CascadeType.ALL)
    private List<SetEntity> sets;
}

package com.fitness_social.measurement_microservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class MeasurementEntity {
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private float value;
    @Column(name = "owner_uid")
    private String ownerUid;
    @Column
    private Unit unit;
    @Column
    private Type type;

}

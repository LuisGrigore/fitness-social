package com.fitness_social.measurement_microservice.dtos;

import com.fitness_social.measurement_microservice.domain.Type;
import com.fitness_social.measurement_microservice.domain.Unit;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class CreateMeasurementDto {
    private float value;
    private String ownerUid;
    private Unit unit;
    private Type type;
}

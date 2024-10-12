package com.fitness_social.measurement_microservice.dtos;

import com.fitness_social.measurement_microservice.domain.Type;
import com.fitness_social.measurement_microservice.domain.Unit;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class GetMeasurementDto {
    private float value;
    private Unit unit;
    private Type type;
}

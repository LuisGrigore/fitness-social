package com.fitness_social.routine_microservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetRoutineDto {
    private String name;
}

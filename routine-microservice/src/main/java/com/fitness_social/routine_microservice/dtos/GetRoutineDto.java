package com.fitness_social.routine_microservice.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetRoutineDto {
    private String name;
    private String description;
    private List<GetSetDto> sets;
}

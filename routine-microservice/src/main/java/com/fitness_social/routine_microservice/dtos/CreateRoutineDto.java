package com.fitness_social.routine_microservice.dtos;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateRoutineDto {
    private String name;
    private String ownerUid;
    private List<CreateSetDto> sets;
}

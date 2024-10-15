package com.fitness_social.complete_recipe_service.dtos;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GetRoutineDto {
    private String name;
    private List<SetDto> setDtoList = new ArrayList<>();
}

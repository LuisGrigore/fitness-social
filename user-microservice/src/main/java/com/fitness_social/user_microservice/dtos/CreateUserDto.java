package com.fitness_social.user_microservice.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CreateUserDto {
    private String uid;
}

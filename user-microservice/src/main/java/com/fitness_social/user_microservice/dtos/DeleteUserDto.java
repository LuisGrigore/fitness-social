package com.fitness_social.user_microservice.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DeleteUserDto {
    private String uid;
}

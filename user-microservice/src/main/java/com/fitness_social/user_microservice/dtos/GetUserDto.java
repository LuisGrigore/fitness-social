package com.fitness_social.user_microservice.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GetUserDto {
    private String uid;
    private String name;
    private int age;
}

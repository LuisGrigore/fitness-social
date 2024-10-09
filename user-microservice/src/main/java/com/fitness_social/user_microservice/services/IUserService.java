package com.fitness_social.user_microservice.services;

import com.fitness_social.user_microservice.dtos.CreateUserDto;
import com.fitness_social.user_microservice.dtos.GetUserDto;

public interface IUserService {
    boolean deleteUser(String uid);
    GetUserDto createUser(CreateUserDto createUserDto);
    GetUserDto getUser(String uid);
}

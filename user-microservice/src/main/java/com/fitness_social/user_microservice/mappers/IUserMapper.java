package com.fitness_social.user_microservice.mappers;

import com.fitness_social.user_microservice.domain.UserEntity;
import com.fitness_social.user_microservice.dtos.CreateUserDto;
import com.fitness_social.user_microservice.dtos.GetUserDto;

public interface IUserMapper {
    UserEntity createUserDtoToUserEntity(CreateUserDto createUserDto);
    GetUserDto UserEntityToGetUserDto(UserEntity userEntity);
}

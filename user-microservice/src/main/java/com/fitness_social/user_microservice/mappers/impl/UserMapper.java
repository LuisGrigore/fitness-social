package com.fitness_social.user_microservice.mappers.impl;

import com.fitness_social.user_microservice.domain.UserEntity;
import com.fitness_social.user_microservice.dtos.CreateUserDto;
import com.fitness_social.user_microservice.dtos.GetUserDto;
import com.fitness_social.user_microservice.mappers.IUserMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements IUserMapper {
    @Override
    public UserEntity createUserDtoToUserEntity(CreateUserDto createUserDto){
        return UserEntity.builder()
                .uid(createUserDto.getUid())
                .name(createUserDto.getName())
                .age(createUserDto.getAge())
                .build();
    }
    @Override
    public GetUserDto UserEntityToGetUserDto(UserEntity userEntity){
        return GetUserDto.builder()
                .uid(userEntity.getUid())
                .name(userEntity.getName())
                .age(userEntity.getAge())
                .build();
    }
}

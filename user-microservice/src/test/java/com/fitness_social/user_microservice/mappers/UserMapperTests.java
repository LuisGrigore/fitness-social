package com.fitness_social.user_microservice.mappers;

import com.fitness_social.user_microservice.domain.UserEntity;
import com.fitness_social.user_microservice.dtos.CreateUserDto;
import com.fitness_social.user_microservice.dtos.GetUserDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserMapperTests {
    private final UserMapper userMapper = new UserMapper();
    @Test
    public void UserMapper_CreateUserToUserEntity_ReturnsUserEntity(){
        String uid = "a";
        String name = "aa";
        int age = 20;
        CreateUserDto createUserDto = CreateUserDto.builder().uid(uid).name(name).age(age).build();
        UserEntity userEntity = userMapper.createUserDtoToUserEntity(createUserDto);

        Assertions.assertThat(userEntity.getUid()).isEqualTo(uid);
        Assertions.assertThat(userEntity.getName()).isEqualTo(name);
        Assertions.assertThat(userEntity.getAge()).isEqualTo(age);
    }
    @Test
    public void UserMapper_UserEntityToGetUserDto_ReturnsGetUserDto(){
        String uid = "a";
        String name = "aa";
        int age = 20;

        UserEntity userEntity = UserEntity.builder().uid(uid).name(name).age(age).build();
        GetUserDto getUserDto = userMapper.UserEntityToGetUserDto(userEntity);

        Assertions.assertThat(getUserDto.getUid()).isEqualTo(uid);
        Assertions.assertThat(getUserDto.getName()).isEqualTo(name);
        Assertions.assertThat(getUserDto.getAge()).isEqualTo(age);
    }
}

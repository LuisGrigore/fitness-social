package com.fitness_social.user_microservice.services;

import com.fitness_social.user_microservice.delete_handler.impl.UserDeleteHandler;
import com.fitness_social.user_microservice.domain.UserEntity;
import com.fitness_social.user_microservice.dtos.CreateUserDto;
import com.fitness_social.user_microservice.dtos.GetUserDto;
import com.fitness_social.user_microservice.mappers.UserMapper;
import com.fitness_social.user_microservice.repos.IUserRepos;
import com.fitness_social.user_microservice.services.impl.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class UserServiceTests {
    @Mock
    private IUserRepos userRepos;
    @Mock
    private UserDeleteHandler userDeleteHandler;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserService userService;
    @Test
    public void UserService_CreateUser_ReturnsGetUserDto(){
        CreateUserDto createUserDto = new CreateUserDto();
        UserEntity userEntity = new UserEntity();
        GetUserDto getUserDto = new GetUserDto();

        when(userRepos.save(Mockito.any(UserEntity.class))).thenReturn(userEntity);
        when(userMapper.UserEntityToGetUserDto(Mockito.any(UserEntity.class))).thenReturn(getUserDto);
        when(userMapper.createUserDtoToUserEntity(Mockito.any(CreateUserDto.class))).thenReturn(userEntity);


        GetUserDto getUserDtoFinal = userService.createUser(createUserDto);

        Assertions.assertThat(getUserDtoFinal).isNotNull();
    }
    @Test
    public void UserService_GetUser_ReturnsGetUserDto(){
        String uid = "a";
        UserEntity userEntity = UserEntity.builder().uid(uid).build();
        GetUserDto getUserDto = new GetUserDto();
        Optional<UserEntity> optionalUserEntity = Optional.of(userEntity);

        when(userRepos.findById(uid)).thenReturn(optionalUserEntity);
        when(userMapper.UserEntityToGetUserDto(Mockito.any(UserEntity.class))).thenReturn(getUserDto);

        GetUserDto getUserDtoFinal = userService.getUser(uid);

        Assertions.assertThat(getUserDtoFinal).isNotNull();

    }
    @Test
    public void UserService_GetUser_ReturnsNull(){
        Optional<UserEntity> optionalUserEmpty = Optional.empty();

        when(userRepos.findById("")).thenReturn(optionalUserEmpty);

        GetUserDto getUserDtoNull = userService.getUser("");

        Assertions.assertThat(getUserDtoNull).isNull();

    }
    @Test
    public void UserService_DeleteUser_ReturnsTrue(){
        when(userDeleteHandler.deleteUser(Mockito.any(String.class))).thenReturn(true);

        boolean userDeleted = userService.deleteUser(Mockito.anyString());

        Assertions.assertThat(userDeleted).isTrue();
    }
    @Test
    public void UserService_DeleteUser_ReturnsFalse(){
        when(userDeleteHandler.deleteUser(Mockito.any(String.class))).thenReturn(false);

        boolean userDeleted = userService.deleteUser(Mockito.anyString());

        Assertions.assertThat(userDeleted).isFalse();
    }
}

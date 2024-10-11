package com.fitness_social.user_microservice.services.impl;

import com.fitness_social.user_microservice.delete_handler.IUserDeleteHandler;
import com.fitness_social.user_microservice.domain.UserEntity;
import com.fitness_social.user_microservice.dtos.CreateUserDto;
import com.fitness_social.user_microservice.dtos.GetUserDto;
import com.fitness_social.user_microservice.mappers.UserMapper;
import com.fitness_social.user_microservice.repos.IUserRepos;
import com.fitness_social.user_microservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepos userRepos;
    @Autowired
    private IUserDeleteHandler userDeleteHandler;

    private final UserMapper userMapper = new UserMapper();

    @Override
    public boolean deleteUser(String uid) {
        return userDeleteHandler.deleteUser(uid);
    }

    @Override
    public GetUserDto createUser(CreateUserDto createUserDto) {
        UserEntity userEntity = userRepos.save(userMapper.createUserDtoToUserEntity(createUserDto));
        return userMapper.UserEntityToGetUserDto(userEntity);
    }

    @Override
    public GetUserDto getUser(String uid) {
        Optional<UserEntity> userOptional = userRepos.findById(uid);
        return userOptional.map(userEntity -> userMapper.UserEntityToGetUserDto(userOptional.get())).orElse(null);
    }
}

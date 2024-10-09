package com.fitness_social.user_microservice.services.impl;

import com.fitness_social.user_microservice.delete_handler.IUserDeleteHandler;
import com.fitness_social.user_microservice.domain.UserEntity;
import com.fitness_social.user_microservice.dtos.CreateUserDto;
import com.fitness_social.user_microservice.dtos.GetUserDto;
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

    @Override
    public boolean deleteUser(String uid) {
        return userDeleteHandler.deleteUser(uid);
    }

    @Override
    public GetUserDto createUser(CreateUserDto createUserDto) {
        UserEntity user = userRepos.save(new UserEntity(createUserDto.getUid()));
        return GetUserDto.builder().uid(user.getUid()).build();
    }

    @Override
    public GetUserDto getUser(String uid) {
        Optional<UserEntity> userOptional = userRepos.findById(uid);
        return userOptional.map(userEntity -> GetUserDto.builder().uid(userEntity.getUid()).build()).orElse(null);
    }
}

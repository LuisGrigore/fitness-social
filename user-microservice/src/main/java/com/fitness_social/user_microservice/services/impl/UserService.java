package com.fitness_social.user_microservice.services.impl;

import com.fitness_social.user_microservice.delete_handler.IUserDeleteHandler;
import com.fitness_social.user_microservice.repos.IUserRepos;
import com.fitness_social.user_microservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

package com.fitness_social.user_microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    @Autowired
    private IUserRepos userRepos;
    @Autowired
    private IUserDeleteHandler userDeleteHandler;

    @Override
    public boolean deleteUser(String uid) {
        return userDeleteHandler.deleteUser(uid);
    }
}

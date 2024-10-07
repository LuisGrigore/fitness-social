package com.example.user_microservice;

import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{
    private IUserRepos userRepos;
    private IUserDeleteHandler userDeleteHandler;

    @Override
    public boolean deleteUser(String uid) {
        return userDeleteHandler.deleteUser(uid);
    }
}

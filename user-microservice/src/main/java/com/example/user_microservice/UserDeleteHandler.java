package com.example.user_microservice;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Optional;

public class UserDeleteHandler implements IUserDeleteHandler{
    @Autowired
    private IUserRepos repos;
    private HashMap<String,UserEntity> pendingDeletion = new HashMap<>();
    @Override
    public boolean deleteUser(String uid) {
        Optional<UserEntity> posibleUser = repos.findById(uid);
        if(posibleUser.isEmpty()) return false;
        pendingDeletion.put(posibleUser.get().getUid(),posibleUser.get());
        repos.deleteById(uid);
        sendUserDeleteEvent();
        return true;
    }
    private void sendUserDeleteEvent(){

    }
    private void recieveRecipeDeleteEvent(String uid){
        //if fail
        repos.save(pendingDeletion.get(uid));
        pendingDeletion.remove(uid);
        //if success
        pendingDeletion.remove(uid);
    }
}

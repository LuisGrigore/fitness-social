package com.fitness_social.user_microservice;

import com.fitness_social.common.RoutineDeleteEvent;
import com.fitness_social.common.UserDeleteEvent;
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
        UserDeleteEvent user = new UserDeleteEvent();
    }
    private void recieveRecipeDeleteEvent(RoutineDeleteEvent routineDeleteEvent){
        if(!routineDeleteEvent.isSuccess()){
            repos.save(pendingDeletion.get(routineDeleteEvent.getUid()));
            pendingDeletion.remove(routineDeleteEvent.getUid());
        }
        if(routineDeleteEvent.isSuccess()) pendingDeletion.remove(routineDeleteEvent.getUid());
    }
}

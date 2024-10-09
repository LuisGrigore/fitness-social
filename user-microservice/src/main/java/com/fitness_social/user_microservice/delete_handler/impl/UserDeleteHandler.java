package com.fitness_social.user_microservice.delete_handler.impl;

import com.fitness_social.common.event_driven.events.RoutineDeleteEvent;
import com.fitness_social.common.event_driven.events.UserDeleteEvent;
import com.fitness_social.user_microservice.delete_handler.IUserDeleteHandler;
import com.fitness_social.user_microservice.domain.UserEntity;
import com.fitness_social.user_microservice.repos.IUserRepos;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Optional;
import static com.fitness_social.common.event_driven.events.configuration.RabbitConfiguration.*;


public class UserDeleteHandler implements IUserDeleteHandler {
    @Autowired
    private IUserRepos repos;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Exchange exchange;
    private HashMap<String, UserEntity> pendingDeletion = new HashMap<>();
    @Override
    public boolean deleteUser(String uid) {
        Optional<UserEntity> posibleUser = repos.findById(uid);
        if(posibleUser.isEmpty()) return false;
        pendingDeletion.put(posibleUser.get().getUid(),posibleUser.get());
        repos.deleteById(uid);
        sendUserDeleteEvent(uid);
        return true;
    }
    private void sendUserDeleteEvent(String uid){
        UserDeleteEvent userDeleteEvent = new UserDeleteEvent(uid);
        rabbitTemplate.convertAndSend(exchange.getName(), USER_ROUTINE_DELETE_QUEUE_ROUTING_KEY, userDeleteEvent);
    }
    @RabbitListener(queues= ROUTINE_USER_DELETE_QUEUE_NAME)
    private void recieveRecipeDeleteEvent(RoutineDeleteEvent routineDeleteEvent){
        if(!routineDeleteEvent.isSuccess()){
            repos.save(pendingDeletion.get(routineDeleteEvent.getUid()));
            pendingDeletion.remove(routineDeleteEvent.getUid());
        }
        if(routineDeleteEvent.isSuccess()) pendingDeletion.remove(routineDeleteEvent.getUid());
    }
}

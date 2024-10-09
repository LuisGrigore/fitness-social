package com.fitness_social.routine_microservice.delete_handler;

import com.fitness_social.common.event_driven.events.MeasurementDeleteEvent;
import com.fitness_social.common.event_driven.events.UserDeleteEvent;
import com.fitness_social.routine_microservice.domain.RoutineEntity;
import com.fitness_social.routine_microservice.repos.IRoutineRepos;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import static com.fitness_social.common.event_driven.events.configuration.RabbitConfiguration.*;

public class UserDeleteHandler{
    @Autowired
    private IRoutineRepos repos;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private Exchange exchange;
    private HashMap<String, List<RoutineEntity>> pendingDeletion = new HashMap<>();

    @RabbitListener(queues= USER_ROUTINE_DELETE_QUEUE_NAME)
    private void recieveUserDeleteEvent(UserDeleteEvent userDeleteEvent){
        Optional<List<RoutineEntity>> routineEntityListOptional= repos.findByOwnerUid(userDeleteEvent.getUid());
        if(routineEntityListOptional.isPresent()){
            for(RoutineEntity routineEntity : routineEntityListOptional.get()){
                repos.delete(routineEntity);
            }
            if(!routineEntityListOptional.get().isEmpty())pendingDeletion.put(routineEntityListOptional.get().get(0).getOwnerUid(),routineEntityListOptional.get());
        }
        rabbitTemplate.convertAndSend(exchange.getName(), ROUTINE_MEASUREMENT_DELETE_QUEUE_ROUTING_KEY, userDeleteEvent);

    }
    @RabbitListener(queues=MEASUREMENT_ROUTINE_DELETE_QUEUE_NAME)
    private void recieveRecipeDeleteEvent(MeasurementDeleteEvent measurementDeleteEvent){
        if(!measurementDeleteEvent.isSuccess()){
            for(RoutineEntity routineEntity : pendingDeletion.get(measurementDeleteEvent.getUid())){
                repos.save(routineEntity);
            }
            pendingDeletion.remove(measurementDeleteEvent.getUid());
        }
        if(measurementDeleteEvent.isSuccess()) pendingDeletion.remove(measurementDeleteEvent.getUid());
    }
}

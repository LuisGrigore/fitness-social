package com.fitness_social.measurement_microservice.delete_handler;

import com.fitness_social.common.event_driven.events.MeasurementDeleteEvent;
import com.fitness_social.common.event_driven.events.UserDeleteEvent;
import com.fitness_social.measurement_microservice.repos.IMeasurementRepos;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;



import static com.fitness_social.common.event_driven.events.configuration.RabbitConfiguration.*;

@Component
public class UserDeleteHandler {
    @Autowired
    private IMeasurementRepos measurementRepos;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RabbitListener(queues= ROUTINE_MEASUREMENT_DELETE_QUEUE_NAME)
    private void recieveUserDeleteEvent(UserDeleteEvent userDeleteEvent){
        measurementRepos.deleteByOwnerUid(userDeleteEvent.getUid());
        rabbitTemplate.convertAndSend(new MeasurementDeleteEvent(userDeleteEvent.getUid(), true));
    }

}

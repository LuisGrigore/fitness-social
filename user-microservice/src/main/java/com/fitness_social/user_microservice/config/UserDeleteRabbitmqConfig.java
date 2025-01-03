package com.fitness_social.user_microservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

import static com.fitness_social.common.event_driven.events.configuration.RabbitConfiguration.*;

@Configuration
public class UserDeleteRabbitmqConfig {
    @Bean
    public TopicExchange eventExchange() {
        return new TopicExchange(USER_DELETE_EXCHANGE_NAME);
    }
    @Bean
    public Queue userRoutineDeleteQueue(){
        return new Queue(USER_ROUTINE_DELETE_QUEUE_NAME);
    }
    @Bean
    public Queue routineUserDeleteQueue(){
        return new Queue(ROUTINE_USER_DELETE_QUEUE_NAME);
    }
    @Bean
    public Binding userRoutineDeleteBinding(TopicExchange exchange){
        return BindingBuilder.bind(userRoutineDeleteQueue()).to(exchange).with(USER_ROUTINE_DELETE_QUEUE_ROUTING_KEY);
    }
    @Bean
    public Binding routineUserDeleteBinding(TopicExchange exchange){
        return BindingBuilder.bind(routineUserDeleteQueue()).to(exchange).with(ROUTINE_USER_DELETE_QUEUE_ROUTING_KEY);
    }
    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of(ALLOWED_LIST_OF_PATTERNS));
        return converter;
    }
    /*@Bean
    public MessageConverter jsonToMapMessageConverter() {
        DefaultClassMapper defaultClassMapper = new DefaultClassMapper();
        defaultClassMapper.setTrustedPackages("com.fitness_social.common"); // trusted packages
        Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        jackson2JsonMessageConverter.setClassMapper(defaultClassMapper);
        return jackson2JsonMessageConverter;
    }*/
}

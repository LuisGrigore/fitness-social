package com.fitness_social.measurement_microservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
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
    public Queue routineMeasurementDeleteQueue(){
        return new Queue(ROUTINE_MEASUREMENT_DELETE_QUEUE_NAME);
    }

    @Bean
    public Queue measurementRoutineDeleteQueue(){
        return new Queue(MEASUREMENT_ROUTINE_DELETE_QUEUE_NAME);
    }


    @Bean
    public Binding routineMeasurementDeleteBinding(TopicExchange exchange){
        return BindingBuilder.bind(routineMeasurementDeleteQueue()).to(exchange).with(ROUTINE_MEASUREMENT_DELETE_QUEUE_ROUTING_KEY);
    }
    @Bean
    public Binding measurementRoutineDeleteBinding(TopicExchange exchange){
        return BindingBuilder.bind(measurementRoutineDeleteQueue()).to(exchange).with(MEASUREMENT_ROUTINE_DELETE_QUEUE_ROUTING_KEY);
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

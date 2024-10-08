package com.fitness_social.user_microservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.SimpleMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class UserDeleteRabbitmqConfig {
    @Bean
    public TopicExchange eventExchange() {
        return new TopicExchange("userDeleteExchange");
    }
    @Bean
    public Queue userDeleteQueue(){
        return new Queue("userDeleteQueue");
    }
    @Bean
    public Queue routineDeleteQueue(){
        return new Queue("routineDeleteQueue");
    }
    @Bean
    public Binding userDeleteBinding(TopicExchange exchange){
        return BindingBuilder.bind(userDeleteQueue()).to(exchange).with("userDeleteQueue");
    }
    @Bean
    public Binding routineDeleteBinding(TopicExchange exchange){
        return BindingBuilder.bind(routineDeleteQueue()).to(exchange).with("routineDeleteQueue");
    }
    @Bean
    public SimpleMessageConverter converter() {
        SimpleMessageConverter converter = new SimpleMessageConverter();
        converter.setAllowedListPatterns(List.of("com.fitness_social.common.*"));
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

package com.fitness_social.user_microservice.config;

import com.fitness_social.user_microservice.delete_handler.UserDeleteHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserDeleteHandlerConfig {
    @Bean
    public UserDeleteHandler userDeleteHandler(){
        return new UserDeleteHandler();
    }
}

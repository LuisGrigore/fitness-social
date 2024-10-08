package com.fitness_social.user_microservice.repos;

import com.fitness_social.user_microservice.domain.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepos extends CrudRepository<UserEntity,String> {
}

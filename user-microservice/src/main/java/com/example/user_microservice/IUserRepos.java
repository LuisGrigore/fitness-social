package com.example.user_microservice;

import org.springframework.data.repository.CrudRepository;

public interface IUserRepos extends CrudRepository<UserEntity,String> {
}

package com.fitness_social.routine_microservice.repos;

import com.fitness_social.routine_microservice.domain.SetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISetRepos extends CrudRepository<SetEntity,Long> {
}

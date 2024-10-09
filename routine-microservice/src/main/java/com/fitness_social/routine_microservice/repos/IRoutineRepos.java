package com.fitness_social.routine_microservice.repos;

import com.fitness_social.routine_microservice.domain.RoutineEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface IRoutineRepos extends CrudRepository<RoutineEntity,Long> {
    Optional<List<RoutineEntity>> findByOwnerUid(String ownerUid);
}

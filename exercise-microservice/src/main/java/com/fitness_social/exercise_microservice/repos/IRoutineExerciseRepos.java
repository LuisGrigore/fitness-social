package com.fitness_social.exercise_microservice.repos;

import com.fitness_social.exercise_microservice.domain.RoutineExerciseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoutineExerciseRepos extends CrudRepository<RoutineExerciseEntity,Long> {
}

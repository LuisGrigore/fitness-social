package com.fitness_social.exercise_microservice.repos;

import com.fitness_social.exercise_microservice.domain.ExerciseEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IExerciseRepos extends CrudRepository<ExerciseEntity,Long> {
}

package com.fitness_social.measurement_microservice.repos;

import com.fitness_social.measurement_microservice.domain.MeasurementEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMeasurementRepos extends CrudRepository<MeasurementEntity,Long> {
    void deleteByOwnerUid(String uid);
}

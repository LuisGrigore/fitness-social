package com.fitness_social.routine_microservice;

import com.fitness_social.routine_microservice.services.IRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutineController {
    @Autowired
    private IRoutineService routineService;
}

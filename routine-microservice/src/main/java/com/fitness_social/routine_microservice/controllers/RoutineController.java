package com.fitness_social.routine_microservice.controllers;

import com.fitness_social.routine_microservice.dtos.CreateRoutineDto;
import com.fitness_social.routine_microservice.dtos.GetRoutineDto;
import com.fitness_social.routine_microservice.services.IRoutineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routines")
public class RoutineController {
    @Autowired
    private IRoutineService routineService;
    @PostMapping
    public ResponseEntity<GetRoutineDto> createRoutine(@RequestBody CreateRoutineDto createRoutineDto){
        return new ResponseEntity<>(routineService.createRoutine(createRoutineDto), HttpStatus.CREATED);
    }

}

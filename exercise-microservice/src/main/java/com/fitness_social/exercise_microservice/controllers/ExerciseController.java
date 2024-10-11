package com.fitness_social.exercise_microservice.controllers;

import com.fitness_social.exercise_microservice.dtos.CreateExerciseDto;
import com.fitness_social.exercise_microservice.dtos.GetExerciseDto;
import com.fitness_social.exercise_microservice.services.IExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/exercises")
public class ExerciseController {
    @Autowired
    private IExerciseService exerciseService;
    @PostMapping
    public ResponseEntity<GetExerciseDto> createExercise(@RequestBody CreateExerciseDto createExerciseDto){
        return new ResponseEntity<>(exerciseService.create(createExerciseDto), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<GetExerciseDto> getExercise(){
        return null;
    }
    @DeleteMapping
    public ResponseEntity<GetExerciseDto> deleteExercise(){
        return null;
    }
}

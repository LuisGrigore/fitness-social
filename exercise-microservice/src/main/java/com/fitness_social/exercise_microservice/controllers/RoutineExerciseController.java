package com.fitness_social.exercise_microservice.controllers;

import com.fitness_social.exercise_microservice.dtos.AddExerciseToRoutineDto;
import com.fitness_social.exercise_microservice.dtos.GetRoutineExerciseDto;
import com.fitness_social.exercise_microservice.services.IRoutineExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/routine/exercise")
public class RoutineExerciseController {
    @Autowired
    private IRoutineExerciseService routineExerciseService;
    @PostMapping
    public ResponseEntity<GetRoutineExerciseDto> addExerciseToRoutine(@RequestBody AddExerciseToRoutineDto addExerciseToRoutineDto){
        return new ResponseEntity<>(routineExerciseService.addExerciseToRoutine(addExerciseToRoutineDto), HttpStatus.CREATED);
    }
}

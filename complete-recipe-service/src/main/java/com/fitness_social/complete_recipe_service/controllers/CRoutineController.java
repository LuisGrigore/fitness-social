package com.fitness_social.complete_recipe_service.controllers;

import com.fitness_social.complete_recipe_service.dtos.GetCompleateRoutineDto;
import com.fitness_social.complete_recipe_service.services.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CRoutineController {
    @Autowired
    private IService service;
    @GetMapping
    public ResponseEntity<GetCompleateRoutineDto> getRecipe(@RequestParam(value = "id",required = false)Long id,
                                                            @RequestParam(value = "name",required = false)String name,
                                                            @RequestParam(value = "owner",required = false)String ownerUid){
        if(id != null) service.getRecipeById(id);
        if(name != null) service.getRecipesByName(name);
        if(ownerUid != null) service.getRecipesByUser(ownerUid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

package com.fitness_social.user_microservice.controllers;

import com.fitness_social.user_microservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam String uid){
        if(userService.deleteUser(uid)) return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}

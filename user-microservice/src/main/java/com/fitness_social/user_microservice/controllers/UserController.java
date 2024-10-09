package com.fitness_social.user_microservice.controllers;

import com.fitness_social.user_microservice.dtos.CreateUserDto;
import com.fitness_social.user_microservice.dtos.DeleteUserDto;
import com.fitness_social.user_microservice.dtos.GetUserDto;
import com.fitness_social.user_microservice.services.IUserService;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private IUserService userService;
    @DeleteMapping
    public ResponseEntity<HttpStatus> deleteUser(@RequestBody DeleteUserDto deleteUserDto){
        if(userService.deleteUser(deleteUserDto.getUid())) return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @PostMapping
    public ResponseEntity<GetUserDto> createUser(@RequestBody CreateUserDto createUserDto){
        return new ResponseEntity<>(userService.createUser(createUserDto),HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<GetUserDto> getUserByUid(@QueryParam("uid") String uid){
        GetUserDto userDto = userService.getUser(uid);
        if(userDto == null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(userDto,HttpStatus.FOUND);
    }
}

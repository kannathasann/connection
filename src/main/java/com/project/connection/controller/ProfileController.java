package com.project.connection.controller;

import com.project.connection.dto.UserDto;
import com.project.connection.service.ProfileService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;

    @PostMapping("/createProfile")
    public ResponseEntity<UserDto> createProfile(@RequestBody UserDto userDto) {
        UserDto response = profileService.createProfile(userDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/viewProfile/{id}")
    public ResponseEntity<UserDto> viewProfile(@PathVariable int id) {
        UserDto userDto = profileService.viewProfile(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);

    }

    @PutMapping("/editProfile/{id}")
    public ResponseEntity<UserDto> editProfile(@PathVariable int id, @RequestBody UserDto userDto) {
        UserDto response = profileService.editProfile(id, userDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/deleteProfile/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable int id) {
        String response = profileService.deleteProfile(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}

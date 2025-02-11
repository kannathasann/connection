package com.project.connection.controller;

import com.project.connection.dto.ResponseObject;
import com.project.connection.entity.Profile;
import com.project.connection.entity.ProfileResponse;
import com.project.connection.entity.User;
import com.project.connection.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfileController {

    @Autowired
    ProfileService profileService;


    @PostMapping("/createProfile")
    public ResponseEntity<ResponseObject> createProfile(@RequestBody Profile profile) {
        ResponseObject response = profileService.createProfile(profile);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/viewProfile/{id}")
    public ResponseEntity<ProfileResponse> viewProfile(@PathVariable int id) {
        ProfileResponse profileResponse = profileService.viewProfile(id);
        return new ResponseEntity<>(profileResponse, HttpStatus.OK);

    }

    //    @PutMapping("/editProfile/{id}")
//    public ResponseEntity<UserDto> editProfile(@PathVariable int id, @RequestBody UserDto userDto) {
//        UserDto response = profileService.editProfile(id, userDto);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
    @DeleteMapping("/deleteProfile/{id}")
    public ResponseEntity<String> deleteProfile(@PathVariable int id) {
        String response = profileService.deleteProfile(id);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}

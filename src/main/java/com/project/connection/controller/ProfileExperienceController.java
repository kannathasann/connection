package com.project.connection.controller;

import com.project.connection.entity.ProfileExperience;
import com.project.connection.service.ProfileExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileExperienceController {

    @Autowired
    ProfileExperienceService profileExperienceService;

    @PostMapping("/createProfileExperience")
    public ResponseEntity<String> createProfileExperience(@RequestBody List<ProfileExperience> profileExperienceList) {
        String response = profileExperienceService.createProfileExperience(profileExperienceList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

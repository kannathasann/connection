package com.project.connection.controller;

import com.project.connection.entity.ProfileEducationDetails;
import com.project.connection.service.ProfileEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProfileEducationController {

    @Autowired
    ProfileEducationService profileEducationService;

    @PostMapping("/createProfileEducation")
    public ResponseEntity<String> createProfileEducation(@RequestBody List<ProfileEducationDetails> profileEducationDetailsList) {
        String response = profileEducationService.createProfileEducation(profileEducationDetailsList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

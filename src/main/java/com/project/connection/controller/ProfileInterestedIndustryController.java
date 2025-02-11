package com.project.connection.controller;

import com.project.connection.entity.Industry;
import com.project.connection.service.ProfileInterestedIndustryServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProfileInterestedIndustryController {

    @Autowired
    ProfileInterestedIndustryServcie profileInterestedIndustryServcie;

    @PostMapping("/createProfileInterestedIndustry")
    public ResponseEntity<String> createProfileInterestedIndustry(@RequestParam int profileId, @RequestBody List<Industry> industryList) {
        String response = profileInterestedIndustryServcie.createProfileInterestedIndustry(profileId, industryList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

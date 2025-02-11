package com.project.connection.controller;

import com.project.connection.entity.Location;
import com.project.connection.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationController {

    @Autowired
    LocationService locationService;

    @PostMapping("/createLocation")
    public ResponseEntity<String> createLocation(@RequestBody List<Location> locationList) {
        String response = locationService.createLocation(locationList);
        return new ResponseEntity<>(response, HttpStatus.CREATED);

    }

}


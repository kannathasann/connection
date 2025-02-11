package com.project.connection.service;

import com.project.connection.entity.Location;
import com.project.connection.repo.LocationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    LocationRepo locationRepo;

    @Override
    public String createLocation(List<Location> locationList) {
        locationList.stream().forEach((location) ->
        {
            locationRepo.save(location);
        });
        return "location created..";
    }
}

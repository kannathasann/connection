package com.project.connection.service;

import com.project.connection.entity.ProfileEducationDetails;
import com.project.connection.repo.ProfileEducationDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileEducationServiceImpl implements ProfileEducationService {

    @Autowired
    ProfileEducationDetailsRepo profileEducationDetailsRepo;

    @Override
    public String createProfileEducation(List<ProfileEducationDetails> profileEducationDetailsList) {
        profileEducationDetailsList.stream().forEach(
                (profileEducationDetails) ->
                        profileEducationDetailsRepo.save(profileEducationDetails)
        );
        return "profile educations created";


    }
}

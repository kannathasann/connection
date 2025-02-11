package com.project.connection.service;

import com.project.connection.entity.ProfileEducationDetails;
import com.project.connection.entity.ProfileExperience;
import com.project.connection.repo.ProfileExperienceRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileExperienceServiceImpl implements ProfileExperienceService {
    @Autowired
    ProfileExperienceRepo profileExperienceRepo;

    @Override
    public String createProfileExperience(List<ProfileExperience> profileExperienceList) {
        profileExperienceList.stream().forEach(
                (profileExperience) ->
                        profileExperienceRepo.save(profileExperience)
        );
        return "profile experience created";
    }
}

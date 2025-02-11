package com.project.connection.entity;

import jakarta.persistence.Column;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class ProfileResponse {
    private User user;
    //   private List<Otp> otpList;
    private Profile profile;
    private List<ProfileEducationDetails> profileEducationDetailsList;
    private List<ProfileExperience> profileExperienceList;
    private List<Industry> profileInterestedIndustry;
    private List<Location> location;
}

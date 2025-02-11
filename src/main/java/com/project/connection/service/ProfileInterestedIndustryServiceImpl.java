package com.project.connection.service;

import com.project.connection.entity.Industry;
import com.project.connection.entity.ProfileInterestedIndustry;
import com.project.connection.repo.ProfileInterestedIndustryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileInterestedIndustryServiceImpl implements ProfileInterestedIndustryServcie {

    @Autowired
    ProfileInterestedIndustryRepo profileInterestedIndustryRepo;

    @Override
    public String createProfileInterestedIndustry(int profileId, List<Industry> industryList) {

        industryList.stream().forEach((industry) ->
        {
            int industryId = industry.getId();
            ProfileInterestedIndustry profileInterestedIndustry = new ProfileInterestedIndustry();
            profileInterestedIndustry.setIndustryId(industryId);
            profileInterestedIndustry.setProfileId(profileId);
            profileInterestedIndustryRepo.save(profileInterestedIndustry);

        });
        return "Interested Industries created";
    }
}

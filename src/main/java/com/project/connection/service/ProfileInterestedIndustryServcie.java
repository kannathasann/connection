package com.project.connection.service;

import com.project.connection.entity.Industry;

import java.util.List;

public interface ProfileInterestedIndustryServcie {

    public String createProfileInterestedIndustry(int profileId, List<Industry> industryList);
}

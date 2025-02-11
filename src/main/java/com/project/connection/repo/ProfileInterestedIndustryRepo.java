package com.project.connection.repo;

import com.project.connection.entity.ProfileInterestedIndustry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileInterestedIndustryRepo extends JpaRepository<ProfileInterestedIndustry, Integer> {
}

package com.project.connection.repo;

import com.project.connection.entity.ProfileExperience;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileExperienceRepo extends JpaRepository<ProfileExperience, Integer> {

    @Query(value = "select * from profile_experience where profile_id=?", nativeQuery = true)
    public List<ProfileExperience> findAllExperienceByProfileId(int profileId);
}

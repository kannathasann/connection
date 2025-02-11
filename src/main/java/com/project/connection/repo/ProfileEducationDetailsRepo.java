package com.project.connection.repo;

import com.project.connection.entity.ProfileEducationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfileEducationDetailsRepo extends JpaRepository<ProfileEducationDetails, Integer> {
    @Query(value = "select * from profile_education_details where profile_id=?", nativeQuery = true)
    public List<ProfileEducationDetails> findAllEducationsByProfileId(int profileId);
}

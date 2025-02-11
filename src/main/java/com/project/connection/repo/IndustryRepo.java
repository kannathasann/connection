package com.project.connection.repo;

import com.project.connection.entity.Industry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndustryRepo extends JpaRepository<Industry, Integer> {

    @Query(value = "SELECT i.*\n" +
            "FROM profile_interested_industry pii\n" +
            "JOIN industry i ON pii.industry_id = i.id\n" +
            "WHERE pii.profile_id = ?", nativeQuery = true)
    public List<Industry> findAllIndustryByProfileId(int profileId);
}

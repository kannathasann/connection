package com.project.connection.repo;

import com.project.connection.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepo extends JpaRepository<Location, Integer> {

    @Query(value = "select * from location where profile_id=?", nativeQuery = true)
    List<Location> findAllLocationsByProfileId(int profileId);
}

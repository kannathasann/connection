package com.project.connection.repo;

import com.project.connection.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepo extends JpaRepository<Profile, Integer> {
    public Profile findByUserId(int id);
}

package com.project.connection.repo;

import com.project.connection.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OtpRepository extends JpaRepository<Otp, Integer> {

    Optional<Otp> findByPhoneNumberAndCode(String phoneNumber, String code);

    void deleteByPhoneNumber(String phoneNumber);
}

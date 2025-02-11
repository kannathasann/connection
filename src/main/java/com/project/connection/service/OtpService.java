package com.project.connection.service;

import com.project.connection.entity.Otp;
import com.project.connection.repo.OtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class OtpService {

    @Autowired
    private OtpRepository otpRepository;

    @Autowired
    private TwilioService twilioService;


    public String generateOtp() {
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000)); // Generate 6-digit OTP
    }

    public void sendOtp(String phoneNumber) {
        String otp = generateOtp();
        Otp otpEntity = new Otp();
        otpEntity.setPhoneNumber(phoneNumber);
        otpEntity.setCode(otp);
        otpEntity.setExpiryTime(LocalDateTime.now().plusMinutes(5)); // OTP valid for 5 mins
        otpRepository.save(otpEntity);

        // Send OTP via Twilio
        twilioService.sendOtp(phoneNumber, otp);
    }

    public boolean validateOtp(String phoneNumber, String code) {
        Optional<Otp> otpOptional = otpRepository.findByPhoneNumberAndCode(phoneNumber, code);
        if (otpOptional.isPresent() && otpOptional.get().getExpiryTime().isAfter(LocalDateTime.now())) {
            //otpRepository.deleteByPhoneNumber(phoneNumber); // OTP used, delete it
            return true;
        }
        return false;
    }
}


package com.project.connection.controller;

import com.project.connection.dto.ResponseObject;
import com.project.connection.service.OtpService;
import com.project.connection.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private OtpService otpService;

    @Autowired
    private ProfileService profileService;

    @PostMapping("/send-otp")
    public ResponseEntity<String> sendOtp(@RequestParam String phoneNumber) {

        otpService.sendOtp(phoneNumber);
        return ResponseEntity.ok("OTP sent successfully");
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<ResponseObject> verifyOtp(@RequestParam String phoneNumber, @RequestParam String otp) {
        if (otpService.validateOtp(phoneNumber, otp)) {
            ResponseObject responseObject = profileService.createUser(phoneNumber);
            return new ResponseEntity<>(responseObject, HttpStatus.ACCEPTED);
        } else {
            ResponseObject responseObject = new ResponseObject(401, "Invalid OTP", null);

            return new ResponseEntity<>(responseObject, HttpStatus.UNAUTHORIZED);
        }
    }
}

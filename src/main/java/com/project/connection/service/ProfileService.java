package com.project.connection.service;

import com.project.connection.dto.UserDto;
import org.springframework.http.ResponseEntity;

public interface ProfileService {
    public UserDto createProfile(UserDto userDto);

    public UserDto viewProfile(int id);

    public UserDto editProfile(int id, UserDto userDto);

    public String deleteProfile(int id);
}

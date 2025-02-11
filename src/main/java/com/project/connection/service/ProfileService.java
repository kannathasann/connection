package com.project.connection.service;

import com.project.connection.dto.ResponseObject;
import com.project.connection.entity.Profile;
import com.project.connection.entity.ProfileResponse;
import com.project.connection.entity.User;

public interface ProfileService {
    //    public UserDto createProfile(UserDto userDto);
    public ResponseObject createUser(String phoneNumber);

    public ResponseObject createProfile(Profile profile);

    public ProfileResponse viewProfile(int id);

    //    public UserDto editProfile(int id, UserDto userDto);
//
    public String deleteProfile(int id);
}

package com.project.connection.service;

import com.project.connection.dto.UserDto;

import java.util.List;

public interface UserService {

    public List<UserDto> getAllUsers();

    public UserDto getUserById(int id);
}

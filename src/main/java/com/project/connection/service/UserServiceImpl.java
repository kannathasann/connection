package com.project.connection.service;

import com.project.connection.dto.UserDto;
import com.project.connection.entity.UserEntity;
import com.project.connection.repo.UserRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public List<UserDto> getAllUsers() {
        List<UserEntity> userEntityList = userRepo.findAll();

        List<UserDto> userDtoList = userEntityList.stream().map((userEntity) -> {
            UserDto userDto = new UserDto();
            BeanUtils.copyProperties(userEntity, userDto);
            return userDto;
        }).collect(Collectors.toList());

        return userDtoList;

    }

    @Override
    public UserDto getUserById(int id) {
        UserEntity userEntity=userRepo.findById(id).orElseThrow();
        UserDto userDto= new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }
}

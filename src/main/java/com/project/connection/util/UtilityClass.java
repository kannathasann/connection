package com.project.connection.util;

import com.project.connection.dto.UserDto;
import com.project.connection.entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UtilityClass {

    public UserEntity dtoTOEntity(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        return userEntity;
    }

    public UserDto entityToDto(UserEntity userEntity) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(userEntity, userDto);
        return userDto;
    }

}

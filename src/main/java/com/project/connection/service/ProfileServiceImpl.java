package com.project.connection.service;

import com.project.connection.dto.UserDto;
import com.project.connection.entity.UserEntity;
import com.project.connection.repo.ProfileRepo;
import com.project.connection.util.UtilityClass;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    ProfileRepo profileRepo;

    @Autowired
    UtilityClass utilityClass;

    @Override
    public UserDto createProfile(UserDto userDto) {
        UserEntity userEntity = utilityClass.dtoTOEntity(userDto);
        UserEntity savedEntity = profileRepo.save(userEntity);
        return utilityClass.entityToDto(savedEntity);


    }

    @Override
    public UserDto viewProfile(int id) {
        UserEntity userEntity = profileRepo.findById(id).orElseThrow();
        return utilityClass.entityToDto(userEntity);
    }

    @Override
    public UserDto editProfile(int id, UserDto userDto) {
        return profileRepo.findById(id)
                .map(existingUser -> {
                    existingUser.setName(userDto.getName());
                    existingUser.setAbout(userDto.getAbout());
                    existingUser.setIdea(userDto.getIdea());
                    existingUser.setAge(userDto.getAge());
                    existingUser.setLocation(userDto.getLocation());
                    existingUser.setExperience(userDto.getExperience());
                    existingUser.setInterested(userDto.getInterested());
                    existingUser.setEducation(userDto.getEducation());

                    profileRepo.save(existingUser);
                    return utilityClass.entityToDto(existingUser);
                })
                .orElseThrow();
    }


    @Override
    public String deleteProfile(int id) {
        profileRepo.deleteById(id);
        return "deleted user successfullyy...";
    }
}

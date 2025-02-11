package com.project.connection.service;

import com.project.connection.dto.ResponseObject;
import com.project.connection.entity.*;
import com.project.connection.repo.*;
import com.project.connection.util.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileServiceImpl implements ProfileService {
    @Autowired
    IndustryRepo industryRepo;
    @Autowired
    LocationRepo locationRepo;
    @Autowired
    OtpRepository otpRepository;
    @Autowired
    ProfileEducationDetailsRepo profileEducationDetailsRepo;
    @Autowired
    ProfileExperienceRepo profileExperienceRepo;
    @Autowired
    ProfileRepo profileRepo;
    @Autowired
    UserRepo userRepo;
    @Autowired
    ProfileResponse profileResponse;

    @Autowired
    UtilityClass utilityClass;

//    @Override
//    public UserDto createProfile(UserDto userDto) {
//        UserEntity userEntity = utilityClass.dtoTOEntity(userDto);
//        UserEntity savedEntity = profileRepo.save(userEntity);
//        return utilityClass.entityToDto(savedEntity);
//
//
//    }


    @Override
    public ResponseObject createUser(String phoneNumber) {
        ResponseObject responseObject = null;
        if (userRepo.findByPhoneNumber(phoneNumber).isEmpty()) {
            User user = new User();
            user.setPhoneNumber(phoneNumber);
            User response = userRepo.save(user);
            long userId = response.getId();

            responseObject = new ResponseObject(200, "User created successfully", userId);

            return responseObject;
        }
        responseObject = new ResponseObject(400, "user is already existed with this phone number, please try with another phone number...", null);

        return responseObject;
    }

    @Override
    public ResponseObject createProfile(Profile profile) {

        Profile response = profileRepo.save(profile);
        int profileId = response.getId();
        ResponseObject responseObject = new ResponseObject(201, "profile created", profileId);
        return responseObject;


    }

    @Override
    public ProfileResponse viewProfile(int id) {
        User user = userRepo.findById(id).orElseThrow();
        profileResponse.setUser(user);
        Profile profile = profileRepo.findByUserId(id);
        if (profile != null) {
            int profileId = profile.getId();
            List<Location> locationList = locationRepo.findAllLocationsByProfileId(profileId);
            List<ProfileEducationDetails> profileEducationDetailsList = profileEducationDetailsRepo.findAllEducationsByProfileId(profileId);
            List<ProfileExperience> profileExperienceList = profileExperienceRepo.findAllExperienceByProfileId(profileId);
            List<Industry> industryList = industryRepo.findAllIndustryByProfileId(profileId);

            profileResponse.setProfile(profile);
            profileResponse.setLocation(locationList);
            profileResponse.setProfileEducationDetailsList(profileEducationDetailsList);
            profileResponse.setProfileExperienceList(profileExperienceList);
            profileResponse.setProfileInterestedIndustry(industryList);
        }

        return profileResponse;


    }

    @Override
    public String deleteProfile(int id) {
        userRepo.deleteById(id);
        return "User deleted successfullyy..";
    }
//
//    @Override
//    public UserDto editProfile(int id, UserDto userDto) {
//        return profileRepo.findById(id)
//                .map(existingUser -> {
//                    existingUser.setName(userDto.getName());
//                    existingUser.setAbout(userDto.getAbout());
//                    existingUser.setIdea(userDto.getIdea());
//                    existingUser.setAge(userDto.getAge());
//                    existingUser.setLocation(userDto.getLocation());
//                    existingUser.setExperience(userDto.getExperience());
//                    existingUser.setInterested(userDto.getInterested());
//                    existingUser.setEducation(userDto.getEducation());
//
//                    profileRepo.save(existingUser);
//                    return utilityClass.entityToDto(existingUser);
//                })
//                .orElseThrow();
//    }

}

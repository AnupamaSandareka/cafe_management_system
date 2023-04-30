package com.cafe.cafe.management.system.service.impl;

import com.cafe.cafe.management.system.dto.UserSignUpDTO;
import com.cafe.cafe.management.system.entity.User;
import com.cafe.cafe.management.system.repo.UserRepo;
import com.cafe.cafe.management.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public String signUp(UserSignUpDTO userSignUpDTO) {

        User user = new User(
                1,
            userSignUpDTO.getUserName(),
            userSignUpDTO.getContact_numbers(),
            userSignUpDTO.getUserEmail(),
            userSignUpDTO.getUserPassword()
        );
        if(!userRepo.existsById(user.getUserId())){
            userRepo.save(user);
            return user.getUserName()+" is saved.";
        }else {
            return "already exist";
        }
    }
}
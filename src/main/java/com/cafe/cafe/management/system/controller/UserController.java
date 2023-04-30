package com.cafe.cafe.management.system.controller;

import com.cafe.cafe.management.system.dto.UserSignUpDTO;
import com.cafe.cafe.management.system.service.UserService;
import com.cafe.cafe.management.system.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/signup")
    public ResponseEntity<StandardResponse> signUp(@RequestBody UserSignUpDTO userSignUpDTO){

        String result = userService.signUp(userSignUpDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(200,result,2),
                HttpStatus.OK
        );
    }
}
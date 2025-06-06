package com.Joyce.bookstore.controller;

import com.Joyce.bookstore.dto.request.AdminLoginRequest;
import com.Joyce.bookstore.dto.response.AdminLoginResponse;
import com.Joyce.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    UserService userService;

    @PostMapping("/admin")
    ResponseEntity<AdminLoginResponse> adminLogin(@RequestBody AdminLoginRequest requestVO){
        return new ResponseEntity<AdminLoginResponse>(userService.adminLogin(requestVO), HttpStatus.OK);
    }
}

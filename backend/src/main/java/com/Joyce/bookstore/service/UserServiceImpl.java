package com.Joyce.bookstore.service;

import com.Joyce.bookstore.domain.User;
import com.Joyce.bookstore.dto.request.AdminLoginRequest;
import com.Joyce.bookstore.dto.response.AdminLoginResponse;
import com.Joyce.bookstore.repository.UserRepository;
import com.Joyce.bookstore.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtils jwtUtils;

    @Override
    public AdminLoginResponse adminLogin(AdminLoginRequest loginReq) {

        User user = userRepository.findByUserName(loginReq.getUserName());

        if(user==null){
            return null;
        }else{
            System.out.println("-----"+user.getUserName() + user.getRole().toString());
            String token = jwtUtils.generateToken(user.getUserName(), user.getRole().toString());
            return new AdminLoginResponse(token);
        }
    }
}

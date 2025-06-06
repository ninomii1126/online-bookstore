package com.Joyce.bookstore.service;

import com.Joyce.bookstore.dto.request.AdminLoginRequest;
import com.Joyce.bookstore.dto.response.AdminLoginResponse;

public interface UserService {

    AdminLoginResponse adminLogin(AdminLoginRequest loginReq);
}

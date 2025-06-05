package com.Joyce.bookstore.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AdminLoginRequest {

    String userName;
    String password;
}

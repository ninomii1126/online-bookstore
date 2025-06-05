package com.Joyce.bookstore.domain;

import com.Joyce.bookstore.constant.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.crypto.password.PasswordEncoder;

@Document("user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private String userName;
    private String password;
    private UserRole role;

    private PasswordEncoder passwordEncoder;

    public void setPassword(String password) {
        this.password = passwordEncoder.encode(password);
    }
}

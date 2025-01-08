package com.apiplatform.model;
import lombok.Data;

public class UserRegistration {

    @Data
    public class UserRegistrationDto {
        private String email;
        private String password;
        private String confirmPassword;
    }
}



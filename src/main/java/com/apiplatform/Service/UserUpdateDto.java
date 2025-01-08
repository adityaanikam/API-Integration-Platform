package com.apiplatform.Service;

// src/main/java/com/apiplatform/model/UserUpdateDto.java
//package com.apiplatform.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserUpdateDto {
    @Email(message = "Please provide a valid email address")
    private String email;

    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    private String firstName;

    private String lastName;

    private String phoneNumber;

    private String company;

    // Optional: If you want to require current password for security
    private String currentPassword;
}

package com.apiplatform.model;



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
    private String currentPassword;
}
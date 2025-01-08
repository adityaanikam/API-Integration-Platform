package com.apiplatform.Service;

import com.apiplatform.config.JwtConfig;
import com.apiplatform.model.*;
import com.apiplatform.repository.UserRepository;
import com.apiplatform.util.ApiKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;




public class User {
    private String email;
    private String password;
    private String apiKey;
    private boolean enabled;
    private String resetToken;
    private long resetTokenExpiry;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getResetToken() {
        return resetToken;
    }

    public void setResetToken(String resetToken) {
        this.resetToken = resetToken;
    }

    public long getResetTokenExpiry() {
        return resetTokenExpiry;
    }

    public void setResetTokenExpiry(long resetTokenExpiry) {
        this.resetTokenExpiry = resetTokenExpiry;
    }
}

//@Service
//public class UserService {
//
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private JwtConfig jwtConfig;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private EmailService emailService;
//
//    public User registerUser(UserRegistration.UserRegistrationDto registrationDto) {
//        if (userRepository.findByEmail(registrationDto.getEmail()) != null) {
//            throw new RuntimeException("Email already registered");
//        }
//
//        User user = new User();
//        user.setEmail(registrationDto.getEmail());
//        user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
//        user.setApiKey(ApiKeyGenerator.generate());
//        user.setEnabled(true);
//
//        User savedUser = userRepository.save(user);
//        emailService.sendWelcomeEmail(savedUser.getEmail(), savedUser.getApiKey());
//
//        return savedUser;
//    }
//
//    public String authenticateUser(LoginDto loginDto) {
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
//        );
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return jwtConfig.generateToken(loginDto.getEmail());
//    }
//
//    public User getCurrentUser() {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        return userRepository.findByEmail(authentication.getName());
//    }
//
//    public String regenerateApiKey() {
//        User user = getCurrentUser();
//        String newApiKey = ApiKeyGenerator.generate();
//        user.setApiKey(newApiKey);
//        userRepository.save(user);
//        emailService.sendApiKeyResetEmail(user.getEmail(), newApiKey);
//        return newApiKey;
//    }
//
//    public void initiatePasswordReset(String email) {
//        com.apiplatform.model.User user = userRepository.findByEmail(email);
//        if (user != null) {
//            String resetToken = ApiKeyGenerator.generate();
//            user.setResetToken(resetToken);
//            user.setResetTokenExpiry(System.currentTimeMillis() + 3600000); // 1 hour
//            userRepository.save(user);
//            emailService.sendPasswordResetEmail(email, resetToken);
//        }
//    }
//
//    public User updateUser(UserUpdateDto updateDto) {
//        User user = getCurrentUser();
//        // Update only provided fields
//        if (updateDto.getPassword() != null) {
//            user.setPassword(passwordEncoder.encode(updateDto.getPassword()));
//        }
//        // Add other fields as needed
//        return userRepository.save(user);
//    }
//
//    public String generateToken(User user) {
//        return jwtConfig.generateToken(user.getEmail());
//    }
//}
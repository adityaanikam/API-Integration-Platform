package com.apiplatform.controller;



import com.apiplatform.model.LandingPage;
import com.apiplatform.model.User;
import com.apiplatform.Service.LandingPageService;
import com.apiplatform.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private LandingPageService landingPageService;

    // User Registration
    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return ResponseEntity.ok(registeredUser);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // User Login
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String username, @RequestParam String password) {
        try {
            boolean isAuthenticated = userService.authenticateUser(username, password);
            if (isAuthenticated) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.status(401).body("Invalid credentials!");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Create Landing Page
    @PostMapping("/landing-page")
    public ResponseEntity<?> createLandingPage(@RequestBody LandingPage landingPage) {
        try {
            LandingPage createdPage = landingPageService.createLandingPage(landingPage);
            return ResponseEntity.ok(createdPage);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }

    // Get Landing Page by ID
    @GetMapping("/landing-page/{id}")
    public ResponseEntity<?> getLandingPage(@PathVariable Long id) {
        try {
            LandingPage landingPage = landingPageService.getLandingPageById(id);
            if (landingPage != null) {
                return ResponseEntity.ok(landingPage);
            } else {
                return ResponseEntity.status(404).body("Landing page not found!");
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error: " + e.getMessage());
        }
    }
}


package com.apiplatform.Service;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

// The Entity and Service are combined into one file for simplicity

@Entity
class LandingPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String content;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

@Repository
interface LandingPageRepository extends JpaRepository<LandingPage, Long> {
    // You can define custom queries here if needed
}

@Service
public class LandingPageService {

    @Autowired
    private LandingPageRepository landingPageRepository;

    // Create a new LandingPage
    public LandingPage createLandingPage(LandingPage landingPage) {
        // Generate unique subdomain (optional)
        String subdomain = generateSubdomain(landingPage.getTitle());
        landingPage.setContent("Subdomain: " + subdomain);

        return landingPageRepository.save(landingPage);
    }

    // Get all LandingPages
    public List<LandingPage> getAllLandingPages() {
        return landingPageRepository.findAll();
    }

    // Get a LandingPage by ID
    public LandingPage getLandingPageById(Long id) {
        return landingPageRepository.findById(id).orElse(null);
    }

    // Update a LandingPage
    public LandingPage updateLandingPage(Long id, LandingPage updatedLandingPage) {
        LandingPage existingLandingPage = landingPageRepository.findById(id).orElse(null);
        if (existingLandingPage != null) {
            existingLandingPage.setTitle(updatedLandingPage.getTitle());
            existingLandingPage.setDescription(updatedLandingPage.getDescription());
            existingLandingPage.setContent(updatedLandingPage.getContent());
            return landingPageRepository.save(existingLandingPage);
        }
        return null;
    }

    // Delete a LandingPage
    public void deleteLandingPage(Long id) {
        landingPageRepository.deleteById(id);
    }

    // Generate a unique subdomain (helper method)
    private String generateSubdomain(String title) {
        return title.toLowerCase()
                .replaceAll("[^a-z0-9]", "")
                + "-"
                + System.currentTimeMillis();
    }
}

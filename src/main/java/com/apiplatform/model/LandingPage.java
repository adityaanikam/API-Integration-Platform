// src/main/java/com/apiplatform/model/LandingPage.java
package com.apiplatform.model;



import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "landing_pages")
public class LandingPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String title;
    private String description;
    private String content;
    private String subdomain;

    @Column(columnDefinition = "TEXT")
    private String htmlContent;

    private boolean published;
    private String theme;
}

/*import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "landing_pages")
public class LandingPage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private String name;
    private String title;
    private String description;
    private String content;
    private String subdomain;

    @Column(columnDefinition = "TEXT")
    private String htmlContent;

    private boolean published;
    private String theme;
}

*/
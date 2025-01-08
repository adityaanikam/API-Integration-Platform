// src/main/java/com/apiplatform/repository/LandingPageRepository.java
package com.apiplatform.repository;

import com.apiplatform.model.LandingPage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
/*
public interface LandingPageRepository extends JpaRepository<LandingPage, Long> {
    List<LandingPage> findByUserId(Long userId);
    LandingPage findBySubdomain(String subdomain);
}

 */




public interface LandingPageRepository extends JpaRepository<LandingPage, Long> {
}

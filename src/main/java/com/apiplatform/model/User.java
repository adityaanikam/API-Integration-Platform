package com.apiplatform.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String apiKey;
    private boolean enabled;
    private String resetToken;
    private Long resetTokenExpiry;

    @Column(name = "stripe_customer_id")
    private String stripeCustomerId;
}
/*import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String password;
    private String apiKey;
    private boolean enabled;

    @Column(name = "stripe_customer_id")
    private String stripeCustomerId;

    public void setResetToken(String resetToken) {
    }

    public void setResetTokenExpiry(long l) {
    }
}*/
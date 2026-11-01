package com.apollopetclinic.apollo.config;

import com.apollopetclinic.apollo.entity.User;
import com.apollopetclinic.apollo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import static com.apollopetclinic.apollo.entity.Role.ROLE_ADMIN;

@Configuration
public class AdminInitializer {

    // Agar Render par variables nahi diye honge, toh ye default values utha lega
    @Value("${ADMIN_EMAIL:admin@apollo.com}")
    private String adminEmail;

    @Value("${ADMIN_PASSWORD:AdminPass123!}")
    private String adminPassword;

    @Bean
    CommandLineRunner initAdmin(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!userRepository.existsByEmail(adminEmail)) {
                User admin = new User();
                admin.setName("Clinic Admin");
                admin.setEmail(adminEmail);
                admin.setPassword(passwordEncoder.encode(adminPassword));
                admin.setRole(ROLE_ADMIN);
                userRepository.save(admin);
                System.out.println("✅ Secure Admin Initialized Successfully!");
            }
        };
    }
}
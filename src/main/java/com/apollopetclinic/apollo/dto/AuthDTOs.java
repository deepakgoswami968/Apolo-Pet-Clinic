package com.apollopetclinic.apollo.dto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AuthDTOs{

    public static class RegisterRequest {
        @NotBlank(message = "Name is required")
        private String name;

        @Email(message = "Invalid Email")
        @NotBlank(message = "Email is required")
        private String email;

        @Size(min = 6, message = "Password must be at least 6 chars")
        private String password;

        private String role;

        public String getName() { return name; }
        public String getEmail() { return email; }
        public String getPassword() { return password; }
        public String getRole() { return role; }
    }

    public static class LoginRequest {
        @Email @NotBlank
        private String email;
        @NotBlank
        private String password;

        public String getEmail() { return email; }
        public String getPassword() { return password; }
    }
}
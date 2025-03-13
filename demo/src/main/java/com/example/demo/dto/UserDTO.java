package com.example.demo.dto;

// A Java record for transferring user data.
// Note: We omit the password field for security.
public record UserDTO(Long id, String username, String email, String role) { }

package com.example.blogmvc.dto;

public record CreateUserDto(
        String username,
        String password,
        String firstName,
        String lastName,
        String dateOfBirth
) {
}

package com.example.blogmvc.controller;

import com.example.blogmvc.dto.CreateUserDto;
import com.example.blogmvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<CreateUserDto> createUser(@RequestBody CreateUserDto createUserDto) {
        return ResponseEntity.ok().body(userService.createUser(createUserDto));
    }
}

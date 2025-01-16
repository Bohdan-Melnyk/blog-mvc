package com.example.blogmvc.service.impl;

import com.example.blogmvc.dto.CreateUserDto;
import com.example.blogmvc.entity.User;
import com.example.blogmvc.repo.UserRepo;
import com.example.blogmvc.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    @SneakyThrows
    public CreateUserDto createUser(CreateUserDto createUserDto) {
        Optional<User> userOptional = userRepo.findByUsername(createUserDto.username());
        if (userOptional.isPresent()) {
            throw new RuntimeException("Username already exists");
        }
        User user = new User();
        user.setUsername(createUserDto.username());
        user.setPassword(createUserDto.password());
        user.setFirstName(createUserDto.firstName());
        user.setLastName(createUserDto.lastName());

        user.setDateOfBirth(new SimpleDateFormat("dd/MM/yyyy").parse(createUserDto.dateOfBirth()));

        userRepo.save(user);

        return createUserDto;
    }
}

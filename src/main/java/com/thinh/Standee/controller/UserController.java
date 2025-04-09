package com.thinh.Standee.controller;

import com.thinh.Standee.dto.request.CreateUserRequest;
import com.thinh.Standee.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        return ResponseEntity.ok().body(
                userService.getAllUsers()
        );
    }

    @PostMapping
    public ResponseEntity<?> createUser(@Validated @RequestBody CreateUserRequest request) {
        return ResponseEntity.ok().body(
                userService.createUser(request)
        );
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @Validated @RequestBody CreateUserRequest request) {
        return ResponseEntity.ok().body(
                userService.updateUser(id, request)
        );
    }
}

package com.thinh.Standee.service;

import com.thinh.Standee.dto.request.CreateUserRequest;
import com.thinh.Standee.dto.response.ApiResponse;

public interface UserService {
    ApiResponse<?> createUser(CreateUserRequest request);
    ApiResponse<?> getAllUsers();
    ApiResponse<?> updateUser(String id, CreateUserRequest request);
}

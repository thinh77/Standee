package com.thinh.Standee.service.impl;

import com.thinh.Standee.dto.request.CreateUserRequest;
import com.thinh.Standee.dto.response.ApiResponse;
import com.thinh.Standee.dto.response.UserDto;
import com.thinh.Standee.entity.UserEntity;
import com.thinh.Standee.exception.DuplicateException;
import com.thinh.Standee.mapper.UserMapper;
import com.thinh.Standee.repository.LocationRepository;
import com.thinh.Standee.repository.UserRepository;
import com.thinh.Standee.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final LocationRepository locationRepository;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public ApiResponse<?> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        List<UserDto> userDtos = userMapper.toDtoList(users);
        return ApiResponse.builder()
                .success(true)
                .message("Get all users successfully")
                .data(userDtos).timestamp(LocalDateTime.now()).build();
    }

    @Override
    @Transactional
    public ApiResponse<?> createUser(CreateUserRequest request) throws DuplicateException
    {
        UserEntity userEntity = userMapper.toEntity(request);
        UserEntity savedEntity = userRepository.save(userEntity);
        UserDto userDto = userMapper.toDto(savedEntity);
        return ApiResponse.<UserDto>builder()
                .success(true)
                .message("Create user successfully")
                .data(userDto).timestamp(LocalDateTime.now()).build();

    }
}

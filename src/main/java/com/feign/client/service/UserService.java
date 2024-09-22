package com.feign.client.service;

import com.feign.client.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> getAll();

    UserDto saveUser(UserDto user);

    Optional<String> updateUser(Long id, UserDto user);

    String deleteUser(Long id);
}

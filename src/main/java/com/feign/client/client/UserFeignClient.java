package com.feign.client.client;

import com.feign.client.config.FeignClientConfiguration;
import com.feign.client.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@FeignClient(name = "USER-MOCK-API", url = "${external.mock.api.base-url}", configuration = FeignClientConfiguration.class)
public interface UserFeignClient {

    @GetMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    List<UserDto> getUser();

    @PostMapping(value = "/users", consumes = MediaType.APPLICATION_JSON_VALUE)
    UserDto saveUser(@RequestBody UserDto user);

    @PutMapping(value = "/users/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    Optional<String> updateUser(@PathVariable Long id, @RequestBody UserDto user);
}

package com.feign.client.controller;

import com.feign.client.dto.UserDto;
import com.feign.client.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto saveUser(@RequestBody UserDto user){
        return userService.saveUser(user);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String updateUser(@PathVariable Long id, @RequestBody UserDto user){
        Optional<String> userOptional = userService.updateUser(id, user);
        if (userOptional.isPresent()){
            user.setName(user.getName());
            user.setUsername(user.getUsername());
            user.setEmail(user.getEmail());
            user.setAvatar(user.getAvatar());
            return "Usuario actualizado";
        }
        return "No se encontro el usuario";
    }
}

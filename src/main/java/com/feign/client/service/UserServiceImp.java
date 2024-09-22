package com.feign.client.service;

import com.feign.client.client.UserFeignClient;
import com.feign.client.dto.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService{

    private final UserFeignClient client;

    @Override
    public List<UserDto> getAll() {
        return client.getUser();
    }

    @Override
    public UserDto saveUser(UserDto user) {
        return client.saveUser(user);
    }

    @Override
    public Optional<String> updateUser(Long id, UserDto user) {
        try {
            // Intenta actualizar el usuario utilizando el cliente
            Optional<String> userOptional = client.updateUser(id, user);

            // Verifica si el cliente devolvió un resultado válido
            if (userOptional.isPresent()) {
                // Devuelve el resultado si la actualización fue exitosa
                return userOptional;
            } else {
                // Si el resultado está vacío, devuelve un Optional vacío
                return userOptional.get().concat("Se actualizo bien").describeConstable();
            }
        } catch (Exception e) {
            // Maneja la excepción, podrías loguearla y devolver un Optional vacío o un mensaje de error
            log.info("Error actualizando usuario: " + e.getMessage());
            // Aquí podrías lanzar una excepción personalizada si lo prefieres
            return Optional.empty();
        }
    }

    @Override
    public String deleteUser(Long id) {
        return null;
    }
}

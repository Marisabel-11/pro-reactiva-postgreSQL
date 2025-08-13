package com.example.ejreactiva.service;

import com.example.ejreactiva.dto.UserCreateDTO;
import com.example.ejreactiva.dto.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    Flux<UserDTO> getAllUsers();
    Mono<UserDTO> getUserById(Integer id);
    Mono<UserDTO> createUser(UserCreateDTO dto);
    Mono<UserDTO> updateUser(Integer id, UserCreateDTO dto);
    Mono<Void> deleteUser(Integer id);
}

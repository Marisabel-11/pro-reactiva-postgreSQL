package com.example.ejreactiva.controller;

import com.example.ejreactiva.dto.UserCreateDTO;
import com.example.ejreactiva.dto.UserDTO;
import com.example.ejreactiva.service.UserService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<UserDTO> getAllUsers() {
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public Mono<UserDTO> getUser(@PathVariable Integer id) {
        return service.getUserById(id);
    }

    @PostMapping
    public Mono<UserDTO> createUser(@RequestBody UserCreateDTO dto) {
        return service.createUser(dto);
    }

    @PutMapping("/{id}")
    public Mono<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserCreateDTO dto) {
        return service.updateUser(id, dto);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteUser(@PathVariable Integer id) {
        return service.deleteUser(id);
    }
}

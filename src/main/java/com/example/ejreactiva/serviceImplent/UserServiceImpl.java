package com.example.ejreactiva.serviceImplent;

import com.example.ejreactiva.dto.UserCreateDTO;
import com.example.ejreactiva.dto.UserDTO;
import com.example.ejreactiva.mapper.UserMapper;
import com.example.ejreactiva.model.User;
import com.example.ejreactiva.repository.UserRepository;
import com.example.ejreactiva.service.UserService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<UserDTO> getAllUsers() {
        return repository.findAll()
                .map(UserMapper::toDTO);
    }

    @Override
    public Mono<UserDTO> getUserById(Integer id) {
        return repository.findById(id)
                .map(UserMapper::toDTO);
    }

    @Override
    public Mono<UserDTO> createUser(UserCreateDTO dto) {
        User user = UserMapper.fromCreateDTO(dto);
        return repository.save(user)
                .map(UserMapper::toDTO);
    }

    @Override
    public Mono<UserDTO> updateUser(Integer id, UserCreateDTO dto) {
        return repository.findById(id)
                .flatMap(existing -> {
                    UserMapper.updateEntity(existing, dto);
                    return repository.save(existing);
                })
                .map(UserMapper::toDTO);
    }

    @Override
    public Mono<Void> deleteUser(Integer id) {
        return repository.deleteById(id);
    }
}

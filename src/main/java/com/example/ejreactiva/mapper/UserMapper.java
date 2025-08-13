package com.example.ejreactiva.mapper;

import com.example.ejreactiva.dto.UserCreateDTO;
import com.example.ejreactiva.dto.UserDTO;
import com.example.ejreactiva.model.User;

public class UserMapper {

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getName(), user.getEmail());
    }

    public static User fromCreateDTO(UserCreateDTO dto) {
        User user = new User();
        user.setName(dto.name());
        user.setEmail(dto.email());
        return user;
    }

    public static void updateEntity(User user, UserCreateDTO dto) {
        user.setName(dto.name());
        user.setEmail(dto.email());
    }
}
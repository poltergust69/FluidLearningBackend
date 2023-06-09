package com.uiktp.finki.ukim.fluidlearning.Service;

import com.uiktp.finki.ukim.fluidlearning.Models.Entities.Users;
import com.uiktp.finki.ukim.fluidlearning.Models.dto.UserDtoRequest;

import java.util.List;

public interface UsersService {
    List<Users> findAll();

    Users findUserById(int userId);

    Users createUser(UserDtoRequest user);

    Users updateUser(int userId, Users user);

    void deleteUser(int userId);

    Users findByUsername(String username);

    Users findByUsernameandPassword(String username, String password);

    Users findAuthenticatedUser();
}

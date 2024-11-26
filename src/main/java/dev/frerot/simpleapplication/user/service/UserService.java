package dev.frerot.simpleapplication.user.service;

import dev.frerot.simpleapplication.dto.LoginRequestDTO;
import dev.frerot.simpleapplication.dto.LoginResponseDTO;
import dev.frerot.simpleapplication.user.modal.User;


public interface UserService {
    User addUser(User user);

    User findUserByEmail(String email);

    User findUserById(String userId);

    LoginResponseDTO loginUser(LoginRequestDTO loginCredentials);
}

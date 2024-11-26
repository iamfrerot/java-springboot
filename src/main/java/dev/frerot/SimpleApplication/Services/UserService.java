package dev.frerot.SimpleApplication.Services;

import dev.frerot.SimpleApplication.DTO.LoginRequestDto;
import dev.frerot.SimpleApplication.DTO.LoginResponseDto;
import dev.frerot.SimpleApplication.Modal.User;


public interface UserService {
    User addUser( User user);
    User findUserByEmail(String email);
    User findUserById(String userId);
    LoginResponseDto loginUser(LoginRequestDto loginCredentials);
}

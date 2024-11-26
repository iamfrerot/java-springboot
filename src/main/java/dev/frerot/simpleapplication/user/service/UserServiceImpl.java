package dev.frerot.simpleapplication.user.service;

import dev.frerot.simpleapplication.dto.LoginRequestDTO;
import dev.frerot.simpleapplication.dto.LoginResponseDTO;
import dev.frerot.simpleapplication.user.exceptions.InvalidCredentials;
import dev.frerot.simpleapplication.user.exceptions.UserNotFoundException;
import dev.frerot.simpleapplication.user.modal.User;
import dev.frerot.simpleapplication.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());
        return this.userRepository.save(user);
    }


    @Override
    public User findUserByEmail(String email) {
        Optional<User> foundUser = this.userRepository.findUserByEmail(email);
        if (foundUser.isPresent()) {
            return foundUser.get();
        } else {
            throw new InvalidCredentials("Invalid Credentials");
        }
    }

    @Override
    public LoginResponseDTO loginUser(LoginRequestDTO loginCredentials) {
        Optional<User> foundUser = this.userRepository.findUserByEmail(loginCredentials.getEmail());
        if (foundUser.isEmpty()) throw new InvalidCredentials("Invalid Credentials");
        return new LoginResponseDTO("your_token key");
    }


    @Override
    public User findUserById(String userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Not Found with: " + userId));
    }

}

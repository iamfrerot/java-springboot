package dev.frerot.SimpleApplication.Services;

import dev.frerot.SimpleApplication.DTO.LoginRequestDto;
import dev.frerot.SimpleApplication.DTO.LoginResponseDto;
import dev.frerot.SimpleApplication.Exceptions.InvalidCredentials;
import dev.frerot.SimpleApplication.Exceptions.UserNotFoundException;
import dev.frerot.SimpleApplication.Modal.User;
import dev.frerot.SimpleApplication.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public User addUser( User user) {
        user.setCreatedAt(LocalDate.now());
        user.setUpdatedAt(LocalDate.now());
        return this.userRepository.save(user);
    }



    @Override
    public User findUserByEmail(String email) {
        Optional<User> foundUser= this.userRepository.findUserByEmail(email);
        if(foundUser.isPresent()){
            return foundUser.get();
        }else {
            throw new InvalidCredentials("Invalid Credentials");
        }
    }

    @Override
    public LoginResponseDto loginUser(LoginRequestDto loginCredentials) {
        User validUser=findUserByEmail(loginCredentials.getEmail());
        boolean passwordMatch=passwordEncoder.matches(loginCredentials.getPassword(),validUser.getPassword());
        if(!passwordMatch) throw new InvalidCredentials("Invalid Credentials");
        return new LoginResponseDto("your_token key");
    }


    @Override
    public User findUserById(String userId) {
        return this.userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User Not Found with: "+ userId));
    }

}

package dev.frerot.simpleapplication.user.controller;

import dev.frerot.simpleapplication.dto.LoginRequestDTO;
import dev.frerot.simpleapplication.dto.LoginResponseDTO;
import dev.frerot.simpleapplication.user.dto.GetUserResponseDTO;
import dev.frerot.simpleapplication.user.dto.NewUserDTO;
import dev.frerot.simpleapplication.user.modal.User;
import dev.frerot.simpleapplication.user.service.UserService;
import dev.frerot.simpleapplication.utils.SuccessResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> addUser(@Valid @RequestBody NewUserDTO user) {
        User createUser = User.builder()
                .age(user.getAge())
                .email(user.getEmail())
                .password(user.getPassword())
                .location(user.getLocation())
                .build();
        SuccessResponse responseBody = new SuccessResponse(201, "Successfully Created user", this.userService.addUser(createUser));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseBody);
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse> loginUser(@Valid @RequestBody LoginRequestDTO loginRequestBody) {
        
        LoginResponseDTO loginResponse = this.userService.loginUser(loginRequestBody);

        SuccessResponse responseBody = new SuccessResponse(200, "success", loginResponse);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("{userId}")
    public ResponseEntity<SuccessResponse> getUserById(@PathVariable String userId) {
        User foundUser = this.userService.findUserById(userId);
        GetUserResponseDTO responseUser = new GetUserResponseDTO(
                foundUser.getEmail(),
                foundUser.getLocation(),
                foundUser.getAge());

        SuccessResponse response = new SuccessResponse(200, "success", responseUser);
        return ResponseEntity.ok(response);
    }

}

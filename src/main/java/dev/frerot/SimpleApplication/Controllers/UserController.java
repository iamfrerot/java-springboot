package dev.frerot.SimpleApplication.Controllers;

import dev.frerot.SimpleApplication.DTO.GetUserResponseDTO;
import dev.frerot.SimpleApplication.DTO.LoginRequestDto;
import dev.frerot.SimpleApplication.DTO.LoginResponseDto;
import dev.frerot.SimpleApplication.DTO.NewUserDTO;
import dev.frerot.SimpleApplication.Modal.User;
import dev.frerot.SimpleApplication.Services.PasswordEncoder;
import dev.frerot.SimpleApplication.Services.UserService;
import dev.frerot.SimpleApplication.Utility.SuccessResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    final private UserService userService;
    final private PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService,PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder= passwordEncoder;
    }

    @PostMapping
    public ResponseEntity<SuccessResponse> addUser(@Valid @RequestBody NewUserDTO user){
        User createUser= User.builder()
                .age(user.getAge())
                .email(user.getEmail())
                .password(passwordEncoder.encode(user.getPassword()))
                .location(user.getLocation())
                .build();
        SuccessResponse responseBody = new SuccessResponse(201,"Successfully Created user",this.userService.addUser(createUser));
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responseBody);
    }

    @PostMapping("/login")
    public ResponseEntity<SuccessResponse> loginUser(@RequestBody LoginRequestDto loginRequestBody){
        LoginResponseDto loginResponse= this.userService.loginUser(loginRequestBody);

        SuccessResponse responseBody= new SuccessResponse(200,"Longed in",loginResponse);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("{userId}")
    public ResponseEntity<SuccessResponse> getUserById(@PathVariable String userId){
        User foundUser = this.userService.findUserById(userId);
        GetUserResponseDTO responseUser = new GetUserResponseDTO(
                foundUser.getEmail(),
                foundUser.getLocation(),
                foundUser.getAge());

        SuccessResponse response= new SuccessResponse(200,"User Found",responseUser);
        return ResponseEntity.ok(response);
    }

}

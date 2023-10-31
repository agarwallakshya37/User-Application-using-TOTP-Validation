package com.application.controller;
import com.application.service.UserService;
import com.application.dto.LoginRequestDto;
import com.application.exception.UserAuthException;
import com.application.dto.RegistrationReqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/register")
  public ResponseEntity<String> registerUser(@RequestBody RegistrationReqDto registrationRequest) {
    try {
      userService.registerUser(registrationRequest);
      return ResponseEntity.ok("User registered successfully");
    } catch (UserAuthException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PostMapping("/login")
  public ResponseEntity<String> loginUser(@RequestBody LoginRequestDto loginRequest) {
    try {
      userService.authenticateUser(loginRequest);
      return ResponseEntity.ok("Login successful");
    } catch (UserAuthException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}

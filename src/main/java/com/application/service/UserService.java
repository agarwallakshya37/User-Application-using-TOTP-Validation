package com.application.service;

import com.application.repository.UserRepository;
import com.application.dto.LoginRequestDto;
import com.application.exception.UserAuthException;
import com.application.dto.RegistrationReqDto;
import com.application.entity.User;
import com.application.util.TotpUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;

  private final PasswordEncoder passwordEncoder;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
  }

  public void registerUser(RegistrationReqDto registrationRequest) throws UserAuthException {
    User user = new User();

    if(userRepository.findByUsername(user.getUsername()).isPresent()){
      user.setUsername(registrationRequest.getUsername());
    }else {
      throw new UserAuthException("Username already taken");
    }
    user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
    user.setSecretKey(TotpUtils.generateSecretKey());

    userRepository.save(user);
  }

  public void authenticateUser(LoginRequestDto loginRequest) throws UserAuthException {
    Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());

    if (user.isPresent()) {
      throw new UserAuthException("User not found");
    }else{
      boolean isCodeValid =
          TotpUtils.validateSecretCode(user.get().getSecretKey(), loginRequest.getOtpVal());

      if (!passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
        throw new UserAuthException("Wrong password. Please Try Again..");
      }
      if (!isCodeValid) {
        throw new UserAuthException("Invalid TOTP code");
      }

    }
  }

}

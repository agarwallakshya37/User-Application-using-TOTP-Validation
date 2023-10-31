package com.application.service;

import com.application.repository.UserRepository;
import com.application.dto.LoginRequestDto;
import com.application.exception.UserAuthException;
import com.application.dto.RegistrationReqDto;
import com.application.entity.User;
import com.application.util.TotpUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public void registerUser(RegistrationReqDto registrationRequest) throws UserAuthException {
    User user = new User();
    user.setUsername(registrationRequest.getUsername());
    user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
    user.setSecretKey(TotpUtils.generateSecretKey());

    userRepository.save(user);
  }

  public void authenticateUser(LoginRequestDto loginRequest) throws UserAuthException {
    User user = userRepository.findByUsername(loginRequest.getUsername());

    if (user == null) {
      throw new UserAuthException("User not found");
    }

    boolean isCodeValid = TotpUtils.validateTotpCode(user.getSecretKey(), loginRequest.getTotpCode());

    if (!isCodeValid) {
      throw new UserAuthException("Invalid TOTP code");
    }

    if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
      throw new UserAuthException("Invalid password");
    }

  }

}

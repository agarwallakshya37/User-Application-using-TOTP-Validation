package com.application.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
  private String username;
  private String password;
  private String otpVal;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getOtpVal() {
    return otpVal;
  }
}

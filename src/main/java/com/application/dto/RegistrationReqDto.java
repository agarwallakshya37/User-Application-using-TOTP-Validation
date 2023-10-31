package com.application.dto;

import lombok.Data;

@Data
public class RegistrationReqDto {
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }
}

package com.application.dto;

import lombok.Data;

@Data
public class LoginRequestDto {
  private String userId;
  private String username;
  private String password;
  private String totpCode;
}

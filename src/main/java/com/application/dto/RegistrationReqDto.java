package com.application.dto;

import lombok.Data;

@Data
public class RegistrationReqDto {
  private String username;
  private String password;
  private String totpCode;
}

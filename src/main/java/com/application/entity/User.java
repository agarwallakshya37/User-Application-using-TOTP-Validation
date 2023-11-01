package com.application.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

  @Id
  private Long id;
  private String username;
  private String password;
  private String secretKey;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getSecretKey() {
    return secretKey;
  }

  public void setSecretKey(String secretKey) {
    this.secretKey = secretKey;
  }
}

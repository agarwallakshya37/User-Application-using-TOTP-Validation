package com.application.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, unique = true)
  private String username;

  @Column(nullable = false)
  private String password;

  @Column(name = "secret_key", nullable = false)
  private String secretKey;

  // Other properties, getters, setters, and constructors
}

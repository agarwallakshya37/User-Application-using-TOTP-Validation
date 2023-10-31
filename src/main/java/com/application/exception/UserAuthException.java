package com.application.exception;

public class UserAuthException extends RuntimeException {
  public UserAuthException(String message) {
    super(message);
  }
}

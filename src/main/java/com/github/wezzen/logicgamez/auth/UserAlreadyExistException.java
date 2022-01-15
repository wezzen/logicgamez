package com.github.wezzen.logicgamez.auth;

public class UserAlreadyExistException extends Exception {
  public UserAlreadyExistException(String s) {
    super(s);
  }
}

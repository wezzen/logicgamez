package com.github.wezzen.logicgamez.auth;

import com.github.wezzen.logicgamez.database.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService extends UserDetailsService {
  void registerNewUserAccount(UserRegistrationDto userDto) throws UserAlreadyExistException;

  Iterable<UserDto> getAllUsers();

  PasswordEncoder getPasswordEncoder();
}

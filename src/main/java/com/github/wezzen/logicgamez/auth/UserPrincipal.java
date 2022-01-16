package com.github.wezzen.logicgamez.auth;

import com.github.wezzen.logicgamez.database.UserDto;
import java.util.Collections;
import java.util.Optional;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class UserPrincipal extends org.springframework.security.core.userdetails.User {

  public UserPrincipal(final UserDto userDto) {
    super(
        userDto.getUsername(),
        userDto.getPassword(),
        Collections.singletonList(
            new SimpleGrantedAuthority(
                Optional.ofNullable(Optional.ofNullable(userDto.getRole()).orElseThrow().getName())
                    .orElseThrow())));
  }
}

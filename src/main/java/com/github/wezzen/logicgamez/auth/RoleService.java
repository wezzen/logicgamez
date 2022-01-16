package com.github.wezzen.logicgamez.auth;

import com.github.wezzen.logicgamez.database.RoleDto;

public interface RoleService {
  String USER = "ROLE_USER";
  String ADMIN = "ROLE_ADMIN";

  RoleDto getOrCreateRole(String roleName);
}

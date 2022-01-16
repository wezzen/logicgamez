package com.github.wezzen.logicgamez.database;

import javax.persistence.*;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "users")
public class UserDto {

  private final @Id @GeneratedValue(strategy = GenerationType.AUTO) @Nullable Long id;

  private final @Column(nullable = false, unique = true) String username;

  private final String password;

  private final String email;

  private @ManyToOne(cascade = {CascadeType.PERSIST}) @Nullable @JoinColumn(nullable = false)
  RoleDto roleDto;

  public UserDto() {
    id = null;
    username = "";
    password = "";
    email = "";
  }

  public UserDto(
      final String username,
      final String password,
      final String email,
      @Nullable final RoleDto roleDto) {
    this.id = null;
    this.username = username;
    this.password = password;
    this.email = email;
    this.roleDto = roleDto;
  }

  public @Nullable Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public String getEmail() {
    return email;
  }

  @Nullable
  public RoleDto getRole() {
    return roleDto;
  }

  public void setRole(final @Nullable RoleDto roleDto) {
    this.roleDto = roleDto;
  }
}

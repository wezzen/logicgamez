package com.github.wezzen.logicgamez.database;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class RoleDto {
  @Id
  @Column(name = "name", nullable = false, length = 50)
  private String name;

  public RoleDto(final String name) {
    this.name = name;
  }

  public RoleDto() {
    this.name = "";
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

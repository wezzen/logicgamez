package com.github.wezzen.logicgamez.database;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDto, Long> {

  boolean existsByEmail(final String email);

  boolean existsByUsername(final String username);

  Optional<UserDto> findByEmail(final String email);
}

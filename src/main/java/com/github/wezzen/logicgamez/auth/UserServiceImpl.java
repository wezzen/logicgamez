package com.github.wezzen.logicgamez.auth;

import com.github.wezzen.logicgamez.database.UserDto;
import com.github.wezzen.logicgamez.database.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final RoleService roleService;
  private final PasswordEncoder encoder = new BCryptPasswordEncoder(15);

  public UserServiceImpl(final UserRepository userRepository, final RoleService roleService) {
    this.roleService = roleService;
    this.userRepository = userRepository;
  }

  @Override
  public void registerNewUserAccount(final UserRegistrationDto userDto)
      throws UserAlreadyExistException {

    if (userRepository.existsByEmail(userDto.getEmail())) {
      throw new UserAlreadyExistException(
          "There is an account with that email address: " + userDto.getEmail());
    }

    if (userRepository.existsByUsername(userDto.getUsername())) {
      throw new UserAlreadyExistException(
          "There is an account with that username: " + userDto.getUsername());
    }

    userRepository.save(
        new UserDto(
            userDto.getUsername(),
            encoder.encode(userDto.getPassword()),
            userDto.getEmail(),
            roleService.getOrCreateRole(RoleService.USER)));
  }

  @Override
  public Iterable<UserDto> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public PasswordEncoder getPasswordEncoder() {
    return encoder;
  }

  @Override
  public UserDetails loadUserByUsername(final String email) {
    return new UserPrincipal(
        userRepository
            .findByEmail(email.toLowerCase())
            .orElseThrow(() -> new UsernameNotFoundException(email)));
  }
}

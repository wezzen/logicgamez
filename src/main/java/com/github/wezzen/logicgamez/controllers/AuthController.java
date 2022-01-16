package com.github.wezzen.logicgamez.controllers;

import com.github.wezzen.logicgamez.auth.UserAlreadyExistException;
import com.github.wezzen.logicgamez.auth.UserRegistrationDto;
import com.github.wezzen.logicgamez.auth.UserService;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {

  private final UserService userService;

  public AuthController(final UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/register")
  public String showRegistrationForm(final Model model) {
    model.addAttribute(new UserRegistrationDto());
    return "registration";
  }

  @PostMapping("/register")
  public String registerUserAccount(
      final Model model,
      final @Valid UserRegistrationDto userRegistrationDTO,
      final BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "registration";
    }
    try {
      userService.registerNewUserAccount(userRegistrationDTO);
    } catch (final UserAlreadyExistException uaeEx) {
      model.addAttribute("message", "An account for that email already exists.");
      return "registration";
    }
    return "redirect:/";
  }

  @GetMapping("/login")
  public String loginPage() {
    return "login";
  }
}

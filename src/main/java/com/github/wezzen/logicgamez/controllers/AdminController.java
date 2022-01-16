package com.github.wezzen.logicgamez.controllers;

import com.github.wezzen.logicgamez.auth.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

  private final UserService userService;

  public AdminController(final UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public String showRegistrationForm(final Model model) {
    model.addAttribute("users", userService.getAllUsers());
    return "admin-page";
  }
}

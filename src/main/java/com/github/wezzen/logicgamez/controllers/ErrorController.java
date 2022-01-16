package com.github.wezzen.logicgamez.controllers;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
  @GetMapping("/error")
  public String getErrorPage(final Model model, final HttpServletRequest request) {
    model.addAttribute("errorCode", request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE));
    model.addAttribute("errorMessage", request.getAttribute(RequestDispatcher.ERROR_MESSAGE));
    return "error";
  }
}

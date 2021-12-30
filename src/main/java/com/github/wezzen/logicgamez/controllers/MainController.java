package com.github.wezzen.logicgamez.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @GetMapping
  @RequestMapping(value = "/")
  public String getMainPage() {
    return "index";
  }
}

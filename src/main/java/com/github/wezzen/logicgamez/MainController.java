package com.github.wezzen.logicgamez;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MainController {

    @GetMapping
    @RequestMapping(value = "/test")
    public String getTestData() {
        return "index";
    }

}

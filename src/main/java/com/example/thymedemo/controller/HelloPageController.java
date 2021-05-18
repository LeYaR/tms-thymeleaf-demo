package com.example.thymedemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloPageController {

    @GetMapping
    public String getHelloPage(@RequestParam(required = false) String param, Model model) {
        model.addAttribute("parameter", param);
        return "hello";
    }
}

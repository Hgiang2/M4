package com.codegym.thuchanh1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GreetingController {
    @GetMapping("/greeting")
    public String greeting(String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}

package com.learnwithifte.springBootCrud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "") String name, Model model) {
        String sayHello  = "Hello "+name;

        model.addAttribute("message", sayHello);
        return "home";
    }
}

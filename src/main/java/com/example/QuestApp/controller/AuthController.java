package com.example.QuestApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AuthController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login.html";
    }

    @GetMapping("/")
    public String greeting() {
        return "welcome.html";
    }

    @GetMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }
}


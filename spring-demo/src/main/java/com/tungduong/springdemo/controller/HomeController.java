package com.tungduong.springdemo.controller;

import com.tungduong.springdemo.model.User;
import com.tungduong.springdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final UserService service;
    public HomeController(UserService service){
        this.service = service;
    }
    @GetMapping("/")
    public String getHomePage(Model model){
        User user = service.getUserByName("Duong").orElse(null);
        model.addAttribute("user",user);
        return "user/index";
    }
}

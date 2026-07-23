package com.tungduong.springdemo.controller;


import com.tungduong.springdemo.model.User;
import com.tungduong.springdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller  // Controller rest chuyên nhận request HTTP trả trực tiếp dữ liệu
@RequestMapping("/user")
public class HelloController {

    private final UserService service;

    public HelloController(UserService service) {
        this.service = service;
    }

    @ModelAttribute("name")
    public String name() {
        return "Dương";
    }

    @GetMapping
    public String showUser(Model model) {
        List<User> userList = service.getUserList();
        model.addAttribute("users",userList);
        return "user/show";
    }
    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("user",new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String postCreatePage(@ModelAttribute User createUser){
        service.createUser(createUser);
        return "redirect:/user";
    }

    @GetMapping("/{id}")
    public String getUpdatePage(Model model, @PathVariable Long id){
        User updateUser =  service.getUserById(id).orElse(null);
        model.addAttribute("user",updateUser);
        return "user/update";
    }
    @PostMapping("/update")
    public String postUpdatePage(@ModelAttribute User updateUser){
        service.updateUser(updateUser);
        return "redirect:/user";
    }

}

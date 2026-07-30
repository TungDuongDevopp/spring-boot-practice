package com.tungduong.springdemo.controller;


import com.tungduong.springdemo.model.User;
import com.tungduong.springdemo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String showUser(Model model) {
        List<User> userList = service.getAllUser();
        model.addAttribute("users",userList);
        return "user/show";
    }
    @GetMapping("/create")
    public String getCreatePage(Model model){
        model.addAttribute("user",new User());
        return "user/create";
    }

    @PostMapping("/create")
    public String postCreatePage(@Valid @ModelAttribute User createUser, BindingResult result){
        if(result.hasErrors()){
            return "user/create";
        }
        service.createUser(createUser);
        return "redirect:/user";
    }

    @GetMapping("/{id}")
    public String getUpdatePage(Model model, @PathVariable Long id){
        User updateUser =  service.findUserById(id).orElse(null);
        model.addAttribute("user",updateUser);
        return "user/update";
    }
    @PostMapping("/update")
    public String postUpdatePage( @Valid @ModelAttribute User updateUser,BindingResult result){
        if(result.hasErrors()){
            return "user/update";
        }
        service.updateUser(updateUser);
        return "redirect:/user";
    }
    @DeleteMapping("/delete/{id}")
    public String postDeletePage(@PathVariable Long id){
        service.deleteUserById(id);
        return "redirect:/user";
    }



}

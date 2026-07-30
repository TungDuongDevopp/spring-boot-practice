package com.tungduong.springdemo.controller;

import com.tungduong.springdemo.model.User;
import com.tungduong.springdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;

@Controller
public class HomeController {

	private final UserService userService;

	public HomeController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/")
	public String index() {
		return "auth/home";
	}

	@GetMapping("/login1")
	public String login() {
		return "auth/login";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "auth/register";
	}

	@PostMapping("/register")
	public String postRegister(@Valid @ModelAttribute User createUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "auth/register";
		}

		if (this.userService.isEmailExist(createUser.getEmail())) {
			bindingResult.rejectValue("email", "email.exists", "Email đã tồn tại, vui lòng sử dụng email khác.");
			return "auth/register";
		}

		this.userService.handleRegister(createUser);

		return "redirect:/login";
	}
}

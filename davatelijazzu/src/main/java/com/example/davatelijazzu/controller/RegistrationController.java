package com.example.davatelijazzu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.davatelijazzu.entity.User;
import com.example.davatelijazzu.service.UserService;


@Controller
public class RegistrationController {

	@Autowired
	private UserService userService;
	@GetMapping("/registration")
	public String registration() {
		return "/registration";
	}
	
	@GetMapping("/activation/{code}")
	public String activation(Model model, @PathVariable String code) {
		boolean isActivated = userService.activateUser(code);
		
		if(isActivated) {
			model.addAttribute("message", "User successfully activated");
		} else {
			model.addAttribute("message", "Activation code is not found");
		}
		
		return "login";
	}
	
	@PostMapping("/registration")
	public String addUser(User user, Model model) {
		if(!userService.addUser(user)) {
			model.addAttribute("message", "User exists!");
			return "/registration";
		}
		
		return "redirect:/login";
	}
}

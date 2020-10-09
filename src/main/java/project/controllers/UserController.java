package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.entity.User;
import project.service.UserService;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping(value = "/user")
	public String user(ModelMap model, @AuthenticationPrincipal User user) {
		model.addAttribute("user", user);
		return "user";
	}


	@PostMapping(value = "/registration")
	public String addUser(@ModelAttribute User user) {
		userService.add(user);
		return "redirect:/login";
	}

	@GetMapping(value = "/registration")
	public String redistrationTo(ModelMap model) {
		model.addAttribute("addForm", new User());
		return "registration";
	}


}



package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.servise.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping(value = "/user")
	public String user(ModelMap model) {
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



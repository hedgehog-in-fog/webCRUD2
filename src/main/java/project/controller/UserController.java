package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.servise.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/")
	public String users(ModelMap modelMap) {
		modelMap.addAttribute("userscrud", userService.allUser());
		return "users";
	}

	@PostMapping(value = "/editUser")
	public String editUser(@ModelAttribute User user) {
		userService.editUser(user);
		return  "redirect:/";
	}

	@PostMapping(value = "/")
	public String addUser(User user) {
		userService.add(user);
		return "redirect:/";
	}

	@GetMapping(value = "/deleteUser")
	public String userDelete(@RequestParam(name = "userId") String id) {
		userService.delete(id);
		return "redirect:/";
	}

//	@PostMapping(value = "/deleteUser")
//	public String deleteUser(@ModelAttribute User user) {
//		userService.delete(user);
//		return "redirect:/";
//	}

//	@GetMapping(value = "/")
//	public String editUser(ModelMap model, User user) {
//		UserService userService = new UserServiceImp();
//		userService.delete(user);
//		return "users";
//	}
}



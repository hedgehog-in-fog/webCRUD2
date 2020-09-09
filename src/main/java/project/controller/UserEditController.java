package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.servise.UserService;

@Controller
public class UserEditController {

	@Autowired
	UserService userService;

	@GetMapping(value = "/editUser")
	public String usersEditForm(ModelMap modelMap, @RequestParam(name = "id") String id) {
		modelMap.addAttribute("eduser", userService.getUserIdByEdit(id));
		return "edituser";
	}

}

package project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import project.entity.User;
import project.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class AdminController {
    @Autowired
    UserService userService;

    @GetMapping(value = "/admin/")
    public String users(ModelMap modelMap) {
        modelMap.addAttribute("userscrud", userService.allUser());
        return "users";
    }

    @PostMapping(value = "/admin/editUser")
    public String editUser(@ModelAttribute User user) {
        userService.editUser(user);
        return  "redirect:/admin/";
    }

    @GetMapping(value = "/admin/editUser")
    public String usersEditForm(ModelMap modelMap, @RequestParam(name = "id") String id) {
        modelMap.addAttribute("editUser", userService.getUserIdByEdit(id));
        return "edituser";
    }



    @GetMapping(value = "/admin/deleteUser")
    public String userDelete(@RequestParam(name = "userId") String id) {
        userService.delete(id);
        return "redirect:/admin/";
    }

    @GetMapping(value = "/admin/addRoleAdmin")
    public String addRoleAdmin(@RequestParam(name = "userId") String id) {
        userService.addRoleAdmin(id);
        return "redirect:/admin/";
    }

    @GetMapping(value = "/admin/hello")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello!");
        messages.add("I'm Spring MVC-SECURITY application");
        messages.add("5.2.0 version by sep'19 ");
        model.addAttribute("messages", messages);
        return "hello";
    }



}

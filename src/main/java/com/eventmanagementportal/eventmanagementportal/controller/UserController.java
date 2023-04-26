package com.eventmanagementportal.eventmanagementportal.controller;

import com.eventmanagementportal.eventmanagementportal.entity.Event;
import com.eventmanagementportal.eventmanagementportal.entity.User;
import com.eventmanagementportal.eventmanagementportal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    //User Registration
    @GetMapping("/addUser/new")
    public String createAddUserForm(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "add_users";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user){
        userService.addUser(user);
        return "redirect:/";
    }

    //Login
    @GetMapping("/loginhere")
    public String showLoginForm(Model model) {
        model.addAttribute("user", new User());
        return "index";
    }

    @PostMapping("/loginhere")
    public String processLogin(@ModelAttribute User user, Model model) {
        String role = userService.login(user.getUsername(), user.getPassword());
        if (role.equals("ADMIN")) {
            model.addAttribute("event", new Event());
            return "add_events";
        } else if (role.equals("USER")) {
            return "redirect:/events";
        } else {
            model.addAttribute("error", "Wrong Credentials, Try Again!");
            return "index";
        }
    }
}

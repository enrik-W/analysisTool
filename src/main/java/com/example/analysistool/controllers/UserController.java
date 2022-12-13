package com.example.analysistool.controllers;

import com.example.analysistool.models.Users;
import com.example.analysistool.repositories.UserRepository;
import com.example.analysistool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String addUser(@ModelAttribute Users user) throws Exception {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new Exception();
        }
        userService.registerUser(user);
        return "newUser";
    }
}

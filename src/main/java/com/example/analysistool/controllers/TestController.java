package com.example.analysistool.controllers;

import com.example.analysistool.models.Users;
import com.example.analysistool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping()
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @RequestMapping("/create")
    public @ResponseBody void createUsers() {
        Users admin = new Users();
        admin.setUsername("admin");
        admin.setAuthorities("ROLE_ADMIN");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        userRepository.save(admin);

        Users user = new Users();
        user.setUsername("user");
        user.setAuthorities("ROLE_USER");
        user.setPassword(bCryptPasswordEncoder.encode("user"));
        userRepository.save(user);
    }

    @RequestMapping("/admin")
    public String adminStuff() {
        return "Secret admin things";
    }
}

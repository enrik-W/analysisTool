package com.example.analysistool.controllers;

import com.example.analysistool.models.Role;
import com.example.analysistool.models.Users;
import com.example.analysistool.repositories.RoleRepository;
import com.example.analysistool.repositories.UserRepository;
import com.example.analysistool.roles.Roles;
import com.example.analysistool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UserService userService;

    @RequestMapping("/all")
    public List<Users> allUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/add")
    public void addUser(@RequestBody Users user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(String.valueOf(Roles.ROLE_USER)));
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }
}

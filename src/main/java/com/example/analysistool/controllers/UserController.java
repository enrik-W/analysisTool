package com.example.analysistool.controllers;

import com.example.analysistool.models.Role;
import com.example.analysistool.models.Users;
import com.example.analysistool.repositories.RoleRepository;
import com.example.analysistool.repositories.UserRepository;
import com.example.analysistool.roles.Roles;
import com.example.analysistool.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public ResponseEntity<List<Users>> allUsers() {
        List<Users> users = userRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Users> addUser(@RequestBody Users user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(String.valueOf(Roles.ROLE_USER)));
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}

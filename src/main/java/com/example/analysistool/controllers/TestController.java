package com.example.analysistool.controllers;

import com.example.analysistool.models.Role;
import com.example.analysistool.models.Users;
import com.example.analysistool.repositories.RoleRepository;
import com.example.analysistool.repositories.UserRepository;
import com.example.analysistool.roles.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.Set;

@RestController
public class TestController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/create")
    public void createUsers() {
        Users admin = new Users();
        admin.setUsername("admin");
        admin.setJobTitle("System administrator");
        admin.setPassword(bCryptPasswordEncoder.encode("admin"));
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(String.valueOf(Roles.ROLE_SYSTEM_ADMIN)));
        admin.setRoles(roles);
        userRepository.save(admin);

        Users superUser = new Users();
        superUser.setUsername("superuser");
        superUser.setJobTitle("Method administrator");
        superUser.setPassword(bCryptPasswordEncoder.encode("superUser"));
        Set<Role> roles2 = new HashSet<>();
        roles2.add(roleRepository.findByRoleName(String.valueOf(Roles.ROLE_USER)));
        roles2.add(roleRepository.findByRoleName(String.valueOf(Roles.ROLE_SUPER_USER)));
        superUser.setRoles(roles2);
        userRepository.save(superUser);
    }

    @RequestMapping("/admin")
    public String adminStuff() {
        return "Secret admin things";
    }
}

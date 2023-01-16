package com.example.analysistool.controllers;

import com.example.analysistool.models.Role;
import com.example.analysistool.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController {
    @Autowired
    private RoleRepository roleRepository;

    @GetMapping("/create")
    public void createRoles() {
        Role user = new Role();
        user.setRoleName("ROLE_USER");
        roleRepository.save(user);

        Role superUser = new Role();
        superUser.setRoleName("ROLE_SUPER_USER");
        roleRepository.save(superUser);

        Role sysAdmin = new Role();
        sysAdmin.setRoleName("ROLE_SYSTEM_ADMIN");
        roleRepository.save(sysAdmin);
    }
}

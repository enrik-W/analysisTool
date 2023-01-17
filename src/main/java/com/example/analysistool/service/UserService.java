package com.example.analysistool.service;

import com.example.analysistool.models.Role;
import com.example.analysistool.models.Users;
import com.example.analysistool.repositories.RoleRepository;
import com.example.analysistool.repositories.UserRepository;
import com.example.analysistool.roles.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public void addUser(Users user) {
        Set<Role> roles = new HashSet<>();
        roles.add(roleRepository.findByRoleName(String.valueOf(Roles.ROLE_USER)));
        user.setRoles(roles);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }
}

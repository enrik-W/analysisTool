package com.example.analysistool.authorization;

import com.example.analysistool.models.Role;
import com.example.analysistool.models.Users;
import com.example.analysistool.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.HashSet;
import java.util.Set;

public class DatabaseUserDetailsService implements UserDetailsService {
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private UserRepository userRepository;

    public UserDetails loadUserByUsername(String username) {
        Users user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }

        Set<SimpleGrantedAuthority> grantedAuthoritySet = new HashSet<>();
        Set<Role> userRoles = user.getRoles();

        for (Role role : userRoles) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new User(user.getUsername(), user.getPassword(), grantedAuthoritySet);
    }
}

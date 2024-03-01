package org.example.service;

import jakarta.transaction.Transactional;
import org.example.Repository.RoleRepository;
import org.example.Repository.UserRepository;
import org.example.models.ApplicationUser;
import org.example.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public ApplicationUser registerUser(String username,String password){
        String encodePassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authority = new HashSet<>();
        authority.add(userRole);

        return userRepository.save(new ApplicationUser(0,username,encodePassword,authority));
    }




}

package org.example;

import org.example.Repository.RoleRepository;
import org.example.Repository.UserRepository;
import org.example.models.ApplicationUser;
import org.example.models.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthenticationBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthenticationBackendApplication.class);
    }
    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder){
        return args -> {
            if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
            Role adminRole =  roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            ApplicationUser admin = new ApplicationUser(1,"admin",passwordEncoder.encode("password"),roles);

            userRepository.save(admin);
        };
    }
}
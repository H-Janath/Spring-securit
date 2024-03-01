package org.example.service;
import org.example.models.ApplicationUser;
import org.example.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the user details service");
        if(!username.equals("Ethen")) throw new UsernameNotFoundException("Not Ether");

        Set<Role> role = new HashSet<>();
        role.add(new Role(1,"USER"));

        return new ApplicationUser(1,"Ethan",encoder.encode("password"),role);

    }
}

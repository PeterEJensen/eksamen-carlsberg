package com.peterpc.services;

//Created by Peter
import com.peterpc.model.Role;
import com.peterpc.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.peterpc.model.User;
import com.peterpc.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

//user service class. registryclass calls actiosn from this (save.user etc)
@Service("userService")
public class UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserService(@Qualifier("userRepository") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }



    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public void saveUser(User user) {

        // Role userRole = roleRepository.findByRole("ROLE_ADMIN");
        //Role userRole = roleRepository.findByRole("ADMIN");
        // user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);

    }


}

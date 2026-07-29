package com.tungduong.springdemo.config;

import com.tungduong.springdemo.service.UserService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private final UserService service;

    public CustomUserDetailService(UserService service) {
        this.service = service;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<com.tungduong.springdemo.model.User> optional =
                service.getUserByEmail(username);

        com.tungduong.springdemo.model.User myUser = optional.orElseThrow(
                () -> new UsernameNotFoundException("Username not found")
        );

        return User.builder()
                .username(myUser.getEmail())
                .password(myUser.getPassword())
                .authorities("ROLE_USER")
                .build();


    }
}

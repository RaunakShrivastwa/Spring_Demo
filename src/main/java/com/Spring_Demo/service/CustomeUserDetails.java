package com.Spring_Demo.service;
import com.Spring_Demo.entity.CustomeUserDetailsService;
import com.Spring_Demo.entity.User;
import com.Spring_Demo.repositery.UserRepositery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomeUserDetails implements UserDetailsService {

    @Autowired
    private UserRepositery repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> userInfo = Optional.ofNullable(repository.findByEmail(username));
        System.out.println("userInfo = " + userInfo);
        return userInfo.map(CustomeUserDetailsService::new)
                .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
    }
}

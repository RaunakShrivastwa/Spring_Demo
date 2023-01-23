package com.Spring_Demo.impl;

import com.Spring_Demo.entity.User;
import com.Spring_Demo.repositery.UserRepositery;
import com.Spring_Demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepositery userRepositery;

    @Override
    public User saveUser(User user) {
        user.setRole("ROLE_NORMAL");
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setId(UUID.randomUUID().toString());
        return this.userRepositery.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return this.userRepositery.findAll();
    }

    @Override
    public User getSingleUser(String id) {
        return this.userRepositery.findById(id).get();
    }
}

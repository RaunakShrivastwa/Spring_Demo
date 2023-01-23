package com.Spring_Demo.service;

import com.Spring_Demo.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    List<User> getAllUser();

    User getSingleUser(String id);
}

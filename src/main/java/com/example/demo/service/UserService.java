package com.example.demo.service;

import com.example.demo.model.User;

public interface UserService {
    User saveUser(User user);
    void addUserToActivity(Integer user_id, Integer activity_id);
    User findByEmail(String email);
}

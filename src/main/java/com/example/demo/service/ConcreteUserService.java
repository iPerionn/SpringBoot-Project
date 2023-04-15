package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Activity;
import com.example.demo.model.User;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConcreteUserService implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ActivityRepository activiteRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void addUserToActivity(Integer user_id, Integer activity_id) {
        Activity activity = activiteRepository.findById(activity_id).orElse(null);
        User user = userRepository.findById(user_id).orElse(null);
        user.getActivities().add(activity);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}

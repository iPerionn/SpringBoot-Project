package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Activity;
import com.example.demo.repository.ActivityRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ConcreteActivityService implements ActivityService{

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public Activity saveActivity(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Iterable<Activity> getActivities() {
        return activityRepository.findAll();
    }

    @Override
    public Activity findById(Integer activity_id) {
        return activityRepository.findById(activity_id).orElse(null);
    }


    
}

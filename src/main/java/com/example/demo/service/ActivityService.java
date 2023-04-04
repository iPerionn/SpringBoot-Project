package com.example.demo.service;

import com.example.demo.model.Activity;

public interface ActivityService {
    public Activity saveActivity(Activity activite);
    public Iterable<Activity> getActivities();
}

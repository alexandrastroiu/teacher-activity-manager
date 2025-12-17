package com.example.activity_manager.service;

import com.example.activity_manager.model.Activity;
import com.example.activity_manager.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    // Create or Update
    public Activity create(Activity activity) {
        return activityRepository.save(activity);
    }

    // Find all
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    // Find by ID
    public List<Activity> findById(Long id) {
        return activityRepository.findByTeacher_TeacherId(id);
    }

    // Delete
    public void delete(Long id) {
        activityRepository.deleteById(id);
    }

}

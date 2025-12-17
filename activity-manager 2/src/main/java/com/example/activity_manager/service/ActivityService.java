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

    // Filtering activities
    // TODO
    public List<Activity> getActivitiesByStatus(Long teacherId, ActivityStatus status) {
        return activityRepository.findByTeacherTeacherIdAndStatus(teacherId, status);
    }

    // TODO
    public List<Activity> getActivitiesSortedByDeadline(Long teacherId) {
        return activityRepository.findByTeacherTeacherIdOrderByEndDateAsc(teacherId);
    }

    // TODO
    public List<Activity> getActivitiesSortedByProgress(Long teacherId) {
        return activityRepository.findByTeacherTeacherIdOrderByProgressDesc(teacherId);
    }

    //TODO
    // Calculate progress
    public void updateProgress(Long activityId) {
        long total = subtaskRepository.countByActivityActivityId(activityId);
        long completed = subtaskRepository.countByActivityActivityIdAndCompletedTrue(activityId);

        int progress = total == 0 ? 0 : (int) ((completed * 100) / total);

        Activity activity = activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));

        activity.setProgress(progress);
        activityRepository.save(activity);
    }

    // TODO Statistics
    //TODO
    public long countCompletedActivities(Long teacherId) {
        return activityRepository.countByTeacherTeacherIdAndStatus(
                teacherId, ActivityStatus.COMPLETED
        );
    }

    // TODO
    public double getAverageProgress(Long teacherId) {
        return activityRepository.findAverageProgressByTeacher(teacherId);
    }

    // TODO
    public Map<YearMonth, Long> getActivitiesPerMonth(Long teacherId) {
        return activityRepository.countActivitiesGroupedByMonth(teacherId);
    }
}

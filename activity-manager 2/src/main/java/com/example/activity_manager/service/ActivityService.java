package com.example.activity_manager.service;

import com.example.activity_manager.model.Activity;
import com.example.activity_manager.model.ActivityStatus;
import com.example.activity_manager.model.Priority;
import com.example.activity_manager.model.Difficulty;
import com.example.activity_manager.repository.ActivityRepository;
import com.example.activity_manager.repository.ActivitySubtaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.YearMonth;
import java.util.Map;
import java.util.Optional;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;
    private final ActivitySubtaskRepository subtaskRepository;

    public ActivityService(ActivityRepository activityRepository, ActivitySubtaskRepository subtaskRepository) {
        this.activityRepository = activityRepository;
        this.subtaskRepository = subtaskRepository;
    }

    // CRUD operations

    // Create or Update
    public Activity create(Activity activity) {
        return activityRepository.save(activity);
    }

    // Delete
    public void delete(Long id) {
        if (!activityRepository.existsById(id)) {
            throw new RuntimeException("Activity not found");
        }
        activityRepository.deleteById(id);
    }

    // Find an activity by ID
    public Activity getById(Long activityId) {
        return activityRepository.findById(activityId)
                .orElseThrow(() -> new RuntimeException("Activity not found"));
    }

    // Find all
    public List<Activity> findAll() {
        return activityRepository.findAll();
    }

    // Get activities for a teacher
    public List<Activity> getActivitiesByTeacher(Long teacherId) {
        return activityRepository.findByTeacher_TeacherId(teacherId);
    }

    // Sorting
    public List<Activity> getActivitiesSortedByDeadline(Long teacherId) {
        return activityRepository.findByTeacher_TeacherIdOrderByEndDateAsc(teacherId);
    }

    // Filtering activities

    public List<Activity> getActivitiesByStatus(Long teacherId, ActivityStatus status) {
        return activityRepository.findByTeacher_TeacherIdAndStatus(teacherId, status);
    }

    public List<Activity> getActivitiesByPriority(
            Long teacherId,
            Priority priority
    ) {
        return activityRepository
                .findByTeacher_TeacherIdAndPriority(teacherId, priority);
    }

    public List<Activity> getActivitiesByDifficulty(
            Long teacherId,
            Difficulty difficulty
    ) {
        return activityRepository
                .findByTeacher_TeacherIdAndDifficulty(teacherId, difficulty);
    }


    // Calculate progress
    public int calculateProgress(Long activityId) {
        long total = subtaskRepository.countByActivity_ActivityId(activityId);
        long completed = subtaskRepository
                .countByActivity_ActivityIdAndIsCompletedTrue(activityId);

        return total == 0 ? 0 : (int) ((completed * 100) / total);
    }


    // Statistics
    public long countCompletedActivities(Long teacherId) {
        return activityRepository.countByTeacher_TeacherIdAndStatus(
                teacherId, ActivityStatus.COMPLETED
        );
    }

    public long countTotalActivities(Long teacherId) {
        return activityRepository.countByTeacher_TeacherId(teacherId);
    }


    public double getAverageProgress(Long teacherId) {
        List<Activity> activities = getActivitiesByTeacher(teacherId);

        if (activities.isEmpty()) return 0;

        return activities.stream()
                .mapToInt(a -> calculateProgress(a.getActivityId()))
                .average()
                .orElse(0);
    }

}

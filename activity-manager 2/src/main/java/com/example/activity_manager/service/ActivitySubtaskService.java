package com.example.activity_manager.service;

import com.example.activity_manager.model.ActivitySubtask;
import com.example.activity_manager.repository.ActivitySubtaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ActivitySubtaskService {

    private final ActivitySubtaskRepository subtaskRepository;

    public ActivitySubtaskService(ActivitySubtaskRepository subtaskRepository) {
        this.subtaskRepository = subtaskRepository;
    }

    // Create or update
    public ActivitySubtask create(ActivitySubtask subtask) {
        return subtaskRepository.save(subtask);
    }

    // Find all
    public List<ActivitySubtask> findAll() {
        return subtaskRepository.findAll();
    }

    // Mark subtask
    public ActivitySubtask setCompleted(Long subtaskId, boolean completed) {
        ActivitySubtask subtask = subtaskRepository.findById(subtaskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Subtask not found"));

        subtask.setIsCompleted(completed);
        return subtaskRepository.save(subtask);
    }

    // Delete subtask
    public void delete(Long subtaskId) {
        if (!subtaskRepository.existsById(subtaskId)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Subtask not found");
        }
        subtaskRepository.deleteById(subtaskId);
    }

    // Get subtasks for an activity
    public List<ActivitySubtask> getSubtasksByActivity(Long activityId) {
        return subtaskRepository.findByActivity_ActivityId(activityId);
    }

}

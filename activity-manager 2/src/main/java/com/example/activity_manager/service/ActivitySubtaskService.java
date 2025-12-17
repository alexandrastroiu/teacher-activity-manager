package com.example.activity_manager.service;

import com.example.activity_manager.model.ActivitySubtask;
import com.example.activity_manager.repository.ActivitySubtaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivitySubtaskService {

    private final ActivitySubtaskRepository subtaskRepository;

    public ActivitySubtaskService(ActivitySubtaskRepository subtaskRepository) {
        this.subtaskRepository = subtaskRepository;
    }

    // Create or update
    public ActivitySubtask save(ActivitySubtask subtask) {
        return subtaskRepository.save(subtask);
    }

    // Find all
    public List<ActivitySubtask> findAll() {
        return subtaskRepository.findAll();
    }

    // Mark subtask
    public void setCompleted(Long subtaskId, boolean completed) {
        ActivitySubtask subtask = subtaskRepository.findById(subtaskId)
                .orElseThrow(() -> new RuntimeException("Subtask not found"));

        subtask.setCompleted(completed);
        subtaskRepository.save(subtask);
    }
}

/**
 * Clasa controller pentru subtask-uri
 *
 * @author Stroiu Alexandra-Ioana
 * @version 26 Decembrie 2025
 */
package com.example.activity_manager.controller;

import com.example.activity_manager.dto.SubtaskCreateDto;
import com.example.activity_manager.dto.SubtaskResponseDto;
import com.example.activity_manager.model.Activity;
import com.example.activity_manager.model.ActivitySubtask;
import com.example.activity_manager.service.ActivityService;
import com.example.activity_manager.service.ActivitySubtaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ActivitySubtaskController {

    private final ActivityService activityService;
    private final ActivitySubtaskService subtaskService;

    public ActivitySubtaskController(ActivityService activityService,
                                     ActivitySubtaskService subtaskService) {
        this.activityService = activityService;
        this.subtaskService = subtaskService;
    }

    // Create subtask for an activity
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/activities/{activityId}/subtasks")
    public SubtaskResponseDto createSubtask(
            @PathVariable Long activityId,
            @Valid @RequestBody SubtaskCreateDto dto
    ) {
        Activity activity = activityService.getById(activityId);

        ActivitySubtask subtask = new ActivitySubtask();
        subtask.setActivity(activity);
        subtask.setTitle(dto.getTitle());
        subtask.setIsCompleted(false);

        ActivitySubtask saved = subtaskService.create(subtask);
        return SubtaskResponseDto.from(saved);
    }

    // List subtasks for an activity
    @GetMapping("/activities/{activityId}/subtasks")
    public List<SubtaskResponseDto> getSubtasksForActivity(@PathVariable Long activityId) {
        return subtaskService.getSubtasksByActivity(activityId)
                .stream()
                .map(SubtaskResponseDto::from)
                .toList();
    }

    // Mark completion for a subtask
    @PatchMapping("/subtasks/{subtaskId}/completed")
    public SubtaskResponseDto setCompleted(
            @PathVariable Long subtaskId,
            @RequestParam boolean value
    ) {
        ActivitySubtask updated = subtaskService.setCompleted(subtaskId, value);
        return SubtaskResponseDto.from(updated);
    }

    // Delete subtask
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/subtasks/{subtaskId}")
    public void deleteSubtask(@PathVariable Long subtaskId) {
        subtaskService.delete(subtaskId);
    }
}

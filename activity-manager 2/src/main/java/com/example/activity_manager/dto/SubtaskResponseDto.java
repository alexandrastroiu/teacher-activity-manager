package com.example.activity_manager.dto;

public class SubtaskResponseDto {

    private Long subtaskId;
    private String title;
    private boolean completed;

    public SubtaskResponseDto(
            Long subtaskId,
            String title,
            boolean completed
    ) {
        this.subtaskId = subtaskId;
        this.title = title;
        this.completed = completed;
    }

    public Long getSubtaskId() {
        return subtaskId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCompleted() {
        return completed;
    }
}

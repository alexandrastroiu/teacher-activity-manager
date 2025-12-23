package com.example.activity_manager.dto;

import com.example.activity_manager.model.ActivityStatus;
import com.example.activity_manager.model.Priority;
import com.example.activity_manager.model.Difficulty;

import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;

public class ActivityCreateDto {

    @NotBlank(message = "Activity title must not be empty")
    private String title;

    private String description;

    private LocalDate startDate;

    @FutureOrPresent(message = "End date must be in the present or future")
    private LocalDate endDate;

    @NotNull(message = "Status cannot be null")
    private ActivityStatus status;

    @NotNull(message = "Priority cannot be null")
    private Priority priority;

    @NotNull(message = "Difficulty cannot be null")
    private Difficulty difficulty;

    // Getters
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }
    public ActivityStatus getStatus() { return status; }
    public Priority getPriority() { return priority; }
    public Difficulty getDifficulty() { return difficulty; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setDescription(String description) { this.description = description; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setStatus(ActivityStatus status) { this.status = status; }
    public void setPriority(Priority priority) { this.priority = priority; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
}

/**
 * Clasa pentru transferul datelor de la client catre API si validarea datelor pentru a actualiza o activitate
 *
 * @author Stroiu Alexandra-Ioana
 * @version 26 Decembrie 2025
 */
package com.example.activity_manager.dto;

import com.example.activity_manager.model.ActivityStatus;
import com.example.activity_manager.model.Priority;
import com.example.activity_manager.model.Difficulty;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.FutureOrPresent;

public class ActivityUpdateDto {
    // Validation Rules
    @NotBlank(message = "Activity title cannot be empty")
    private String title;

    private String description;

    private LocalDate startDate;

    @FutureOrPresent(message = "End date must be in the present or future")
    private LocalDate endDate;

    @NotNull(message = "Activity status cannot be null")
    private ActivityStatus status;

    @NotNull(message = "Priority cannot be null")
    private Priority priority;

    @NotNull(message = "Difficulty cannot be null")
    private Difficulty difficulty;

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ActivityStatus getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    // Setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setStatus(ActivityStatus status) {
        this.status = status;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }
}

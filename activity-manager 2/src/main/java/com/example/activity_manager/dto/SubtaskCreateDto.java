package com.example.activity_manager.dto;

import jakarta.validation.constraints.NotBlank;

public class SubtaskCreateDto {
    @NotBlank(message = "Subtask title must not be empty")
    private String title;

    // Default constructor
    public SubtaskCreateDto() {
    }

    // Setter
    public void setTitle(String title) { this.title = title; }

    // Getter
    public String getTitle() {
        return title;
    }

}

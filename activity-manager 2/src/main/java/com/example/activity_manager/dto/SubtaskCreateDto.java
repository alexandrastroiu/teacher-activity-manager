package com.example.activity_manager.dto;

public class SubtaskCreateDto {
    @NotBlank(message = "Subtask title must not be empty")
    private String title;

    // Default constructor
    public SubtaskCreateDto() {}

    // Getter
    public String getTitle() {
        return title;
    }

}

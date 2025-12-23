package com.example.activity_manager.dto;

import com.example.activity_manager.model.AttendanceStatus;

public class AttendanceUpdateDto {
    @NotNull(message = "Attendance status must not be empty")
    private AttendanceStatus status;

    // Getter
    public AttendanceStatus getStatus() {
        return status;
    }

    // Setter
    public void setStatus(AttendanceStatus status) {
        this.status = status;
    }
}

package com.example.activity_manager.dto;

import com.example.activity_manager.model.AttendanceStatus;

public class AttendanceResponseDto {

    private Long sessionId;
    private Long studentId;
    private String studentName;
    private String groupName;
    private AttendanceStatus status;

    // Getters
    public Long getSessionId() {
        return sessionId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getGroupName() {
        return groupName;
    }

    public AttendanceStatus getStatus() {
        return status;
    }

    // Constructor
    public AttendanceResponseDto(
            Long sessionId,
            Long studentId,
            String studentName,
            String groupName,
            AttendanceStatus status
    ) {
        this.sessionId = sessionId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.groupName = groupName;
        this.status = status;
    }
}

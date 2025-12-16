/** Clasa pentru prezenta studentilor
 * @author Stroiu Alexandra-Ioana
 * @version 15 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Attendance")
public class Attendance {
    @EmbeddedId
    private AttendanceId id; // composite Primary Key

    @ManyToOne
    @MapsId("sessionId")
    @JoinColumn(name = "session_id")
    private CourseSession session;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    @Enumerated(EnumType.STRING)
    @Column(name = "attendance_status", nullable = false)
    private AttendanceStatus attendanceStatus = AttendanceStatus.ABSENT;

    // getters & setters
}

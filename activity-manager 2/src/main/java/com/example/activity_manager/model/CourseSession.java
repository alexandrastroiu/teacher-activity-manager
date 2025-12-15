/** Clasa pentru sesiuni de curs
 * @author Stroiu Alexandra-Ioana
 * @version 15 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Course_Sessions")
public class CourseSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name="session_date", nullable = false)
    private LocalDate sessionDate;

    @Column(name="session_time", nullable = false)
    private LocalTime sessionTime;

    @Column(name="duration")
    private LocalTime duration;

    // getters & setters
}

/**
 * Clasa pentru transferul datelor de raspuns catre client pentru cursuri
 *
 * @author Stroiu Alexandra-Ioana
 * @version 26 Decembrie 2025
 */
package com.example.activity_manager.dto;

import com.example.activity_manager.model.Course;

public class CourseResponseDto {
    private Long courseId;
    private String courseName;

    public CourseResponseDto(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Getters
    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public static CourseResponseDto from(Course c) {
        return new CourseResponseDto(
                c.getCourseId(),
                c.getCourseName()
        );
    }
}

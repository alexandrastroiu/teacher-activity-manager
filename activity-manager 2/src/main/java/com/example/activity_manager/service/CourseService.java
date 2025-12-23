package com.example.activity_manager.service;

import com.example.activity_manager.model.Course;
import com.example.activity_manager.repository.CourseRepository;
import com.example.activity_manager.repository.CourseSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;
    private final CourseSessionRepository sessionRepository;

    // Constructor
    public CourseService(CourseRepository courseRepository, CourseSessionRepository sessionRepository) {
        this.courseRepository = courseRepository;
        this.sessionRepository = sessionRepository;
    }

    // Get courses for a teacher
    public List<Course> getCoursesByTeacher(Long teacherId) {
        return courseRepository.findByTeacher_TeacherId(teacherId);
    }

    // Get the number of sessions for a course
    public Long countSessionsForCourse(Long courseId) {
        return sessionRepository.countByCourseCourseId(courseId);
    }
}

package com.example.activity_manager.service;

import com.example.activity_manager.model.Course;
import com.example.activity_manager.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getCoursesByTeacher(Long teacherId) {
        return courseRepository.findByTeacher_TeacherId(teacherId);
    }
}

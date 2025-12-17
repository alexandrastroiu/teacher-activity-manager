package com.example.activity_manager.service;

import com.example.activity_manager.model.CourseSession;
import com.example.activity_manager.repository.CourseSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSessionService {

    private final CourseSessionRepository sessionRepository;

    public CourseSessionService(CourseSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<CourseSession> getSessionsByCourse(Long courseId) {
        return sessionRepository.findByCourse_CourseId(courseId);
    }
}

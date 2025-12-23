package com.example.activity_manager.service;

import com.example.activity_manager.model.CourseSession;
import com.example.activity_manager.repository.CourseSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseSessionService {

    private final CourseSessionRepository sessionRepository;

    // Constructor
    public CourseSessionService(CourseSessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    // Find sessions related to a specific course
    public List<CourseSession> getSessionsByCourse(Long courseId) {
        return sessionRepository.findByCourse_CourseId(courseId);
    }

    // CRUD operations

    // Create session
    public CourseSession createSession(CourseSession session) {
        return sessionRepository.save(session);
    }

    // Update session
    public CourseSession updateSession(Long sessionId, CourseSession updated) {
        CourseSession session = sessionRepository.findById(sessionId)
                .orElseThrow(() -> new RuntimeException("Session not found"));

        session.setSessionDate(updated.getSessionDate());
        session.setSessionTime(updated.getSessionTime());
        session.setDuration(updated.getDuration());

        return sessionRepository.save(session);
    }

    // Delete session
    public void deleteSession(Long sessionId) {
        if (!sessionRepository.existsById(sessionId)) {
            throw new RuntimeException("Session not found");
        }
        sessionRepository.deleteById(sessionId);
    }
}

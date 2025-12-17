package com.example.activity_manager.service;

import com.example.activity_manager.model.Teacher;
import com.example.activity_manager.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher getByUserId(Long userId) {
        return teacherRepository.findByUserUserId(userId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
    }
}

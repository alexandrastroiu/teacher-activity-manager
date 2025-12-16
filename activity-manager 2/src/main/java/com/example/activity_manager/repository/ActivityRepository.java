package com.example.activity_manager.repository;

import com.example.activity_manager.model.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findByTeacher_TeacherId(Long teacherId);
}

/**
 * Clasa pentru accesul la baza de date pentru inscrieri
 *
 * @author Stroiu Alexandra-Ioana
 * @version 26 Decembrie 2025
 */
package com.example.activity_manager.repository;

import com.example.activity_manager.model.CourseEnrollment;
import com.example.activity_manager.model.CourseEnrollmentId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseEnrollmentRepository extends JpaRepository<CourseEnrollment, CourseEnrollmentId> {
    List<CourseEnrollment> findByCourseCourseId(Long courseId);
}

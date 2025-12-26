/**
 * Clasa pentru accesul la baza de date pentru prezenta
 *
 * @author Stroiu Alexandra-Ioana
 * @version 26 Decembrie 2025
 */
package com.example.activity_manager.repository;

import com.example.activity_manager.model.Attendance;
import com.example.activity_manager.model.AttendanceId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttendanceRepository extends JpaRepository<Attendance, AttendanceId> {
    List<Attendance> findBySession_SessionId(Long sessionId);
}

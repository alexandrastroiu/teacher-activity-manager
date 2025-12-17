/** Clasa pentru cheia compusa
 * @author Stroiu Alexandra-Ioana
 * @version 17 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CourseEnrollmentId implements Serializable {
    private Long studentId;
    private Long courseId;

    // Default constructor
    public CourseEnrollmentId() {}

    public CourseEnrollmentId(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // Equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CourseEnrollmentId)) {
            return false;
        }

        CourseEnrollmentId otherId = (CourseEnrollmentId) obj;
        return Objects.equals(studentId, otherId.studentId) && Objects.equals(courseId, otherId.courseId);
    }

    // Hashcode method
    @Override
    public int hashCode() {
        return Objects.hash(studentId, courseId);
    }
}

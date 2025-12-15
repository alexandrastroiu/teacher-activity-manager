/** Clasa pentru cursuri
 * @author Stroiu Alexandra-Ioana
 * @version 15 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    @Column(nullable = false, unique = true)
    private String courseName;

    @Enumerated(EnumType.STRING)
    private CourseType courseType; /// TODO

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;

    //  getters & setters

}

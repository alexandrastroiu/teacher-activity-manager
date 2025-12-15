/** Clasa pentru profesori
 * @author Stroiu Alexandra-Ioana
 * @version 15 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;

import javax.annotation.processing.Generated;

@Entity
@Table(name="Teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long teacherId;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name="department_id", nullable = false)
    private Department departmentId;

    // getters & setters
}

/** Clasa pentru studenti
 * @author Stroiu Alexandra-Ioana
 * @version 15 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @OneToOne
    @JoinColumn(name="user_id", nullable = false)
    private User userId;

    @ManyToOne
    @JoinColumn(name = "group_id", nullable = false)
    private StudentGroup group;

    // getters & setters

}

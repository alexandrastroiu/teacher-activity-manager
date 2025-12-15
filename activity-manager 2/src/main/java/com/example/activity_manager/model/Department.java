package com.example.activity_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name="Departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long departmentId;

    @Column(name="department_name", nullable = false, unique = true)
    private String departmentName;
}

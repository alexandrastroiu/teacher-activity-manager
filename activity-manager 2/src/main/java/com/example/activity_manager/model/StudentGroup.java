/** Clasa pentru grupele de studenti
 * @author Stroiu Alexandra-Ioana
 * @version 16 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Student_Groups")
public class StudentGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentGroupId;

    @Column(name="group_name", nullable = false)
    private String groupName;

    // Default constructor
    public StudentGroup() {}

    // Getters
    public Long getStudentGroupId() {
        return studentGroupId;
    }

    public String getGroupName() {
        return groupName;
    }

    // Setters
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

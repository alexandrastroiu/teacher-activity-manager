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
    @Column(name = "group_id")
    private Long groupId;

    @Column(name="group_name", nullable = false)
    private String groupName;

    // Default constructor
    public StudentGroup() {}

    // Getters
    public Long getStudentGroupId() {
        return groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    // Setters
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}

/** Clasa pentru subtask-uri
 * @author Stroiu Alexandra-Ioana
 * @version 15 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Activity_Subtasks")
public class ActivitySubtask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subtaskId;

    @ManyToOne
    @JoinColumn(name = "activity_id", nullable = false)
    private Activity activity;

    @Column(name="title", nullable = false)
    private String title;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted = false;

    // getters & setters
}

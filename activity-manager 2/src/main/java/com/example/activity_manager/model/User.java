/** Clasa pentru utilizatori
 * @author Stroiu Alexandra-Ioana
 * @version 15 Decembrie 2025
 */
package com.example.activity_manager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable=false, unique=true)
    private String username;

    @Column(name="user_password", nullable = false)
    private String userPassword;

    @Enumerated(EnumType.STRING)
    @Column(name="user_role", nullable=false)
    private String userRole;

    @Column(name="user_email", unique=true)
    private String userEmail;

    // getters & setters

}


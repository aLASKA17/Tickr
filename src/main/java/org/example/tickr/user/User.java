package org.example.tickr.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(schema="public", name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String userName;
    private String userEmail;
    private String userPassword;
    private LocalDateTime userAtCreated;
    private LocalDateTime userAtUpdate;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    @PrePersist
    public void createUser() {
        this.userAtCreated = LocalDateTime.now();
        this.userAtUpdate = LocalDateTime.now();
    }

    @PreUpdate
    public void updateUser() {
        this.userAtUpdate = LocalDateTime.now();
    }
}

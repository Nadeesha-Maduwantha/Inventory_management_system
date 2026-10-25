package com.headoffice.stockms.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotaions.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class User{

    @Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID id;

    @Column( nullable = false, unique = true,length = 50)
    private String username;


    @Column( nullable = false, unique = true,length = 150)
    private String email;

    @Column( name = "password_hash",nullable = false)
    private String passwordHash;

    @Enumerated(EnumType.STRING)
    @Column( nullable = false,length = 50)
    private Role role;

    @Builder.Default
    @Column(name = "is_active",nullable = false)
    private boolean isActive = true;

    @CreationTimestamp
    @Column(name= "created_at",nullable = false,updatable =false)
    private LocalDateTime createdAt;
    
    @UpdateTimestamp
    @Column(name="updated_at",nullable=fales)
    private LocalDateTime updatedAt;

}
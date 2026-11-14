package com.example.javaspring;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Entity = JPA maps this class to a database table named "task"
@Entity
// Lombok writes getId()/setId(), getDescription()/setDescription(),
// isCompleted()/setCompleted() for you at compile time
@Getter
@Setter
// JPA needs an empty constructor to build objects from database rows
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private boolean completed;
}

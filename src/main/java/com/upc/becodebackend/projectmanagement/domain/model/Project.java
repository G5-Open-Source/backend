package com.upc.becodebackend.projectmanagement.domain.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private LocalDate startDate;

    // Constructor vacío
    public Project() {}

    // Constructor con campos
    public Project(String name, String description, LocalDate startDate) {
        this.name = name;
        this.description = description;
        this.startDate = startDate;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
}

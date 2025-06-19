package com.upc.becodebackend.projectmanagement.domain.model;

import jakarta.persistence.*;

@Entity
public class Hiring {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long projectId;
    private Long userId;
    private String status;

    public Hiring() {}

    public Hiring(Long projectId, Long userId, String status) {
        this.projectId = projectId;
        this.userId = userId;
        this.status = status;
    }

    public Long getId() { return id; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

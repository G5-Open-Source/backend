package com.upc.becodebackend.projectmanagement.api.resources;

public class CreateHiringResource {
    private Long projectId;
    private Long userId;
    private String status;

    // Getters y setters
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

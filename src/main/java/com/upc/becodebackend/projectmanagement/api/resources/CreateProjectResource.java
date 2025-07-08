package com.upc.becodebackend.projectmanagement.api.resources;

import java.time.LocalDate;

public class CreateProjectResource {
    private String name;
    private String description;
    private LocalDate startDate;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getStartDate() { return startDate; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
}

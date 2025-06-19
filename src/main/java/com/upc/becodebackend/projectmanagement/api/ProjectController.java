package com.upc.becodebackend.projectmanagement.api;

import com.upc.becodebackend.projectmanagement.application.services.ProjectService;
import com.upc.becodebackend.projectmanagement.domain.model.Project;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProjects() {
        return projectService.getAllProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectService.createProject(project);
    }
}

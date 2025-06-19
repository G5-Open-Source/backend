package com.upc.becodebackend.projectmanagement.application.services;

import com.upc.becodebackend.projectmanagement.domain.model.Project;
import com.upc.becodebackend.projectmanagement.domain.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }
}

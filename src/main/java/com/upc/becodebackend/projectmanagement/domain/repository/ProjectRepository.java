package com.upc.becodebackend.projectmanagement.domain.repository;

import com.upc.becodebackend.projectmanagement.domain.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}

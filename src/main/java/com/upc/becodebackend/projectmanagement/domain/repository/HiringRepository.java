package com.upc.becodebackend.projectmanagement.domain.repository;

import com.upc.becodebackend.projectmanagement.domain.model.Hiring;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HiringRepository extends JpaRepository<Hiring, Long> {
}

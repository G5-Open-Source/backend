package com.upc.becodebackend.publication.domain.repositories;

import com.upc.becodebackend.publication.domain.aggregates.Publication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
    List<Publication> findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(String title, String description);
}
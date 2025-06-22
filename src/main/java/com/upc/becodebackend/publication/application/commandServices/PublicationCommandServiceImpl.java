package com.upc.becodebackend.publication.application.commandServices;

import com.upc.becodebackend.publication.domain.aggregates.Publication;
import com.upc.becodebackend.publication.domain.repositories.PublicationRepository;
import com.upc.becodebackend.publication.interfaces.rest.resources.*;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PublicationCommandServiceImpl implements PublicationCommandService {

    private final PublicationRepository publicationRepository;

    public PublicationCommandServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public PublicationResource createPublication(CreatePublicationResource resource) {
        Publication publication = Publication.builder()
                .title(resource.getTitle())
                .description(resource.getDescription())
                .createdAt(LocalDateTime.now())
                .freelancerId(resource.getFreelancerId())
                .build();

        publication = publicationRepository.save(publication);

        return mapToResource(publication);
    }

    @Override
    public PublicationResource updatePublication(Long id, UpdatePublicationResource resource) {
        Publication publication = publicationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publication not found"));
        publication.setTitle(resource.getTitle());
        publication.setDescription(resource.getDescription());

        return mapToResource(publicationRepository.save(publication));
    }

    @Override
    public void deletePublication(Long id) {
        publicationRepository.deleteById(id);
    }

    private PublicationResource mapToResource(Publication publication) {
        PublicationResource resource = new PublicationResource();
        resource.setId(publication.getId());
        resource.setTitle(publication.getTitle());
        resource.setDescription(publication.getDescription());
        resource.setCreatedAt(publication.getCreatedAt().toString());
        return resource;
    }
}
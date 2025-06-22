package com.upc.becodebackend.publication.application.queryServices;

import com.upc.becodebackend.publication.domain.aggregates.Publication;
import com.upc.becodebackend.publication.domain.repositories.PublicationRepository;
import com.upc.becodebackend.publication.interfaces.rest.resources.PublicationResource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PublicationQueryServiceImpl implements PublicationQueryService {

    private final PublicationRepository publicationRepository;

    public PublicationQueryServiceImpl(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    @Override
    public List<PublicationResource> searchPublications(String query) {
        return publicationRepository
                .findByTitleContainingIgnoreCaseOrDescriptionContainingIgnoreCase(query, query)
                .stream()
                .map(this::mapToResource)
                .collect(Collectors.toList());
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
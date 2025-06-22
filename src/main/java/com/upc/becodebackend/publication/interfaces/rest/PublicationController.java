package com.upc.becodebackend.publication.interfaces.rest;

import com.upc.becodebackend.publication.application.commandServices.PublicationCommandService;
import com.upc.becodebackend.publication.application.queryServices.PublicationQueryService;
import com.upc.becodebackend.publication.interfaces.rest.resources.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/publications")
public class PublicationController {

    private final PublicationQueryService publicationQueryService;
    private final PublicationCommandService publicationCommandService;

    public PublicationController(PublicationQueryService publicationQueryService,
                                 PublicationCommandService publicationCommandService) {
        this.publicationQueryService = publicationQueryService;
        this.publicationCommandService = publicationCommandService;
    }

    @PostMapping
    public ResponseEntity<PublicationResource> createPublication(@RequestBody CreatePublicationResource resource) {
        PublicationResource created = publicationCommandService.createPublication(resource);
        return ResponseEntity.status(201).body(created);
    }

    @GetMapping("/search")
    public ResponseEntity<List<PublicationResource>> search(@RequestParam String query) {
        List<PublicationResource> results = publicationQueryService.searchPublications(query);
        return ResponseEntity.ok(results);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublicationResource> updatePublication(@PathVariable Long id,
                                                                 @RequestBody UpdatePublicationResource resource) {
        PublicationResource updated = publicationCommandService.updatePublication(id, resource);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublication(@PathVariable Long id) {
        publicationCommandService.deletePublication(id);
        return ResponseEntity.noContent().build();
    }
}

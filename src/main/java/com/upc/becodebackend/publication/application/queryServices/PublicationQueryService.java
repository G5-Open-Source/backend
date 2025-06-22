package com.upc.becodebackend.publication.application.queryServices;

import com.upc.becodebackend.publication.interfaces.rest.resources.PublicationResource;
import java.util.List;

public interface PublicationQueryService {
    List<PublicationResource> searchPublications(String query);
}
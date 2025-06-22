package com.upc.becodebackend.publication.application.commandServices;

import com.upc.becodebackend.publication.interfaces.rest.resources.*;

public interface PublicationCommandService {
    PublicationResource createPublication(CreatePublicationResource resource);
    PublicationResource updatePublication(Long id, UpdatePublicationResource resource);
    void deletePublication(Long id);
}
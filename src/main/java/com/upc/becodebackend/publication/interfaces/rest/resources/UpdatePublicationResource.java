package com.upc.becodebackend.publication.interfaces.rest.resources;

import lombok.Data;

@Data
public class UpdatePublicationResource {
    private String title;
    private String description;
}
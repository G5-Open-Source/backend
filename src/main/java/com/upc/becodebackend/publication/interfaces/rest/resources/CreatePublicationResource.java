package com.upc.becodebackend.publication.interfaces.rest.resources;

import lombok.Data;

@Data
public class CreatePublicationResource {
    private String title;
    private String description;
    private String freelancerId;
}
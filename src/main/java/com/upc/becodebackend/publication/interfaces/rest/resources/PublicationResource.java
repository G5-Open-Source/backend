package com.upc.becodebackend.publication.interfaces.rest.resources;

import java.util.function.LongBinaryOperator;

import lombok.Data;

@Data
public class PublicationResource {
    private Long id;
    private String title;
    private String description;
    private String createdAt;
}
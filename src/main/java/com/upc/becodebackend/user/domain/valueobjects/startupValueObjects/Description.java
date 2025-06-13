/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.valueobjects.startupValueObjects;

import jakarta.persistence.Embeddable;

/**
 *
 * @author Rodrigo Liberato
 */
@Embeddable
public record Description(String description) {

    public Description() {this(null);}
    public Description{
        if (description == null || description.isBlank()) {
            throw new IllegalArgumentException("description is required");
        }
    }
}

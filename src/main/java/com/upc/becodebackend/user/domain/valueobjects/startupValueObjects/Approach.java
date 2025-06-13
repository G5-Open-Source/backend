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
public record Approach(String Approach) {
    public Approach() {this(null);}
    public Approach{
        if (Approach == null || Approach.isBlank()) {
            throw new IllegalArgumentException("Approach is required");
        }
    }
}

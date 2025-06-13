/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.valueobjects;

import jakarta.persistence.Embeddable;

/**
 *
 * @author Rodrigo Liberato
 */
@Embeddable
public record Dni(String DNI) {
    public Dni(){this(null);}
    public Dni{
        if (DNI == null || DNI.isBlank()){
            throw new IllegalArgumentException("DNI is required");
        }
    }
}

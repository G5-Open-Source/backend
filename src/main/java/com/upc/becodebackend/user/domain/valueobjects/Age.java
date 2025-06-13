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
public record Age(String age) {
    public Age() {this(null);}

   public Age{
        if (age == null || age.isBlank()){
            throw new IllegalArgumentException("Age is required");
        }
    }
}

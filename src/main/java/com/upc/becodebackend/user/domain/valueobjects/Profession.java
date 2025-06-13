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
public record Profession(String profession) {
    public Profession() {this(null);}

   public Profession{
        if (profession == null || profession.isBlank()){
            throw new IllegalArgumentException("Profession is required");
        }
    }
}

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
public record EmailUser(String email) {
    public EmailUser() {this(null);}

   public EmailUser{
        if (email == null || email.isBlank()){
            throw new IllegalArgumentException("Email address is required");
        }
    }
}

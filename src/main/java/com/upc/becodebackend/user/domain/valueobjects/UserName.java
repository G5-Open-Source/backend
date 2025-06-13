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
public record UserName(String firstName, String lastName) {
    public UserName() {this(null,null);}
    public UserName{
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name is required");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name is required");
        }
    }

    public String getFullName(){
        return String.format("%s %s", firstName, lastName);
    }

}

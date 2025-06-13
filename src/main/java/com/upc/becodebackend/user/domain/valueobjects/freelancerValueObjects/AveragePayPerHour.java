/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects;

import java.math.BigDecimal;

import jakarta.persistence.Embeddable;

/**
 *
 * @author Rodrigo Liberato
 */
@Embeddable

public record AveragePayPerHour(BigDecimal payment) {
    public AveragePayPerHour() {this(null);}
    public AveragePayPerHour{
        if (payment == null) {
            throw new IllegalArgumentException("PayPerHour is required");
        }

    }

}

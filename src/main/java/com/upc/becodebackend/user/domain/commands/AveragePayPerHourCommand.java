/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.commands;

import java.math.BigDecimal;

/**
 *
 * @author Rodrigo Liberato
 */
public record AveragePayPerHourCommand(BigDecimal payment) {
    public AveragePayPerHourCommand{
        if (payment != null && payment.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Average pay per hour cannot be negative");
    }

    }
    
}

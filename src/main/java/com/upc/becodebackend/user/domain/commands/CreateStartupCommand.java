/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.commands;

import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.HiringStatus;

/**
 *
 * @author Rodrigo Liberato
 */
public record CreateStartupCommand(
    String firstname,
    String lastName,
    String email,
    String dni,
    String password,
    String age,
    String profession,
    String StartupName,
    DescriptionCommand description,
    ApproachCommand approach,
    HiringStatus hiringStatus,
    WorkersAmmountCommand workers
) {
    public CreateStartupCommand {
        if (firstname == null || firstname.trim().isEmpty()) {
            throw new IllegalArgumentException("Firstname cannot be null or empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("LastName cannot be null or empty");
        }
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("DNI cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (age == null || age.trim().isEmpty()) {
            throw new IllegalArgumentException("Age cannot be null or empty");
        }
        if (profession == null || profession.trim().isEmpty()) {
            throw new IllegalArgumentException("Profession cannot be null or empty");
        }
        if (workers == null) {
            throw new IllegalArgumentException("Workers count cannot be null");
        }
    }
}
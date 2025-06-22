package com.upc.becodebackend.user.domain.commands;

import java.util.List;

import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.WorkingStatus;

public record CreateFreelancerCommand(
    String firstname,
    String lastName,
    String email,
    String dni,
    String password,
    String age,
    String profession,
    List<StudyCertificateCommand> studyCertificates,
    WorkingStatus workingStatus,
    AveragePayPerHourCommand averagePayPerHour
) {
    public CreateFreelancerCommand {
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
        if (studyCertificates == null) {
            throw new IllegalArgumentException("StudyCertificates cannot be null");
        }
        if (averagePayPerHour == null) {
            throw new IllegalArgumentException("Average pay per hour cannot be null");
        }
    }
}

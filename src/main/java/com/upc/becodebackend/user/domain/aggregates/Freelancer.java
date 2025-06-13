/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.domain.aggregates;

import java.util.ArrayList;
import java.util.List;

import com.upc.becodebackend.user.domain.commands.AveragePayPerHourCommand;
import com.upc.becodebackend.user.domain.commands.StudyCertificateCommand;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.AveragePayPerHour;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.StudyCertificate;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.WorkingStatus;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Rodrigo Liberato
 */
@Entity
@Setter
@Getter
@DiscriminatorValue("FREELANCER")
@Table(name = "Freelancers")
public class Freelancer extends BaseUser {
    @Embedded
    @ElementCollection
    @CollectionTable(name = "freelancer_certificates", joinColumns = @JoinColumn(name = "freelancer_id"))
    @Column(name = "certificate")
    private List<StudyCertificate> studyCertificates;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "working_status")
    private WorkingStatus workingStatus;

    @Embedded
    @Column(name = "average_pay_per_hour")
    private AveragePayPerHour averagePayPerHour;

    public Freelancer() {
        super();
        this.studyCertificates = new ArrayList<>();
    }

    public Freelancer(String firstname, String lastName, String email, String dni, String password, 
                     String age, String profession, List<StudyCertificate> studyCertificates, 
                     WorkingStatus workingStatus, AveragePayPerHour averagePayPerHour) {
        super(firstname, lastName, email, dni, password, age, profession);
        this.studyCertificates = studyCertificates != null ? studyCertificates : new ArrayList<>();
        this.workingStatus = workingStatus;
        this.averagePayPerHour = averagePayPerHour;
    }

    public Freelancer(String firstname, String lastName, String email, String dni, String password, String age,
            String profession, List<StudyCertificateCommand> studyCertificates2, WorkingStatus workingStatus2,
            AveragePayPerHourCommand averagePayPerHour2) {
    }

    public void addStudyCertificate(StudyCertificate certificate) {
        if (this.studyCertificates == null) {
            this.studyCertificates = new ArrayList<>();
        }
        this.studyCertificates.add(certificate);
    }

    public void removeStudyCertificate(StudyCertificate certificate) {
        if (this.studyCertificates != null) {
            this.studyCertificates.remove(certificate);
        }
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.domain.aggregates;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.upc.becodebackend.user.domain.commands.AveragePayPerHourCommand;
import com.upc.becodebackend.user.domain.commands.CreateFreelancerCommand;
import com.upc.becodebackend.user.domain.commands.StudyCertificateCommand;
import com.upc.becodebackend.user.domain.valueobjects.EmailUser;
import com.upc.becodebackend.user.domain.valueobjects.Profession;
import com.upc.becodebackend.user.domain.valueobjects.UserName;
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
public class Freelancer extends BaseUser<Freelancer> {

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

    public Freelancer(CreateFreelancerCommand command) {
        super(command.firstname(), command.lastName(), command.email(), command.dni(), 
            command.password(), command.age(), command.profession());
        
         
        this.studyCertificates = new ArrayList<>();
        

        if (command.studyCertificates() != null && !command.studyCertificates().isEmpty()) {
            for (StudyCertificateCommand certName : command.studyCertificates()) {
                this.studyCertificates.add(new StudyCertificate( certName.Name(), certName.Description(), certName.AdquisitionDate()
                ));
            }}

    }


    public void addStudyCertificate(String name, String description, Date acquisitionDate) {
        if (this.studyCertificates == null) {
            this.studyCertificates = new ArrayList<>();
        }
        this.studyCertificates.add(new StudyCertificate( name, description, acquisitionDate));
    }
    public void addStudyCertificateFromCommand(StudyCertificateCommand command) {
    if (this.studyCertificates == null) {
        this.studyCertificates = new ArrayList<>();
    }
    this.studyCertificates.add(new StudyCertificate(
        command.Name(), 
        command.Description(), 
        command.AdquisitionDate()
    ));
    }


    public List<String> getStudyCertificateNames() {
        if (this.studyCertificates == null || this.studyCertificates.isEmpty()) {
            return new ArrayList<>();
        }
        return this.studyCertificates.stream()
                .map(StudyCertificate::Name)
                .toList();
    }


    public List<StudyCertificate> getCertificatesByName(String name) {
        if (this.studyCertificates == null || this.studyCertificates.isEmpty()) {
            return new ArrayList<>();
        }
        return this.studyCertificates.stream()
                .filter(cert -> cert.Name().equalsIgnoreCase(name))
                .toList();
    }


    public BigDecimal getAveragePayPerHourValue() {
        return this.averagePayPerHour != null ? 
            this.averagePayPerHour.payment() : null; 
    }

    @Override
    public String getFullName(){
        return fullName.getFullName();
    }
    
    public void setEmail(EmailUser email) {
        this.email = email;
    }

    public void setFullName(UserName fullName) {
        this.fullName = fullName;
    }

    public void setProfession(Profession profession) {
        this.profession = profession;
    }

    public void setWorkingStatus(WorkingStatus workingStatus) {
        this.workingStatus = workingStatus;
    }

    public void setAveragePayPerHour(AveragePayPerHour averagePayPerHour) {
        this.averagePayPerHour = averagePayPerHour;
    }

    public List<StudyCertificate> getStudyCertificates() {
        return this.studyCertificates;
    }

    
}

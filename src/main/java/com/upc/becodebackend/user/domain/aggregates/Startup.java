/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.domain.aggregates;

import com.upc.becodebackend.user.domain.commands.CreateStartupCommand;
import com.upc.becodebackend.user.domain.commands.DescriptionCommand;
import com.upc.becodebackend.user.domain.commands.WorkersAmmountCommand;
import com.upc.becodebackend.user.domain.valueobjects.EmailUser;
import com.upc.becodebackend.user.domain.valueobjects.Profession;
import com.upc.becodebackend.user.domain.valueobjects.UserName;
import com.upc.becodebackend.user.domain.valueobjects.UserRoles;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.AveragePayPerHour;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.WorkingStatus;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.Approach;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.Description;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.HiringStatus;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.WorkersAmmount;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Rodrigo Liberato
 */

@Entity
@Getter
@Setter
@DiscriminatorValue("STARTUP")
@Table(name = "Startups")
public class Startup extends BaseUser<Startup> {

    @Column(name = "startup_name")
    private String name;

    @Column(name = "description", columnDefinition = "Descripcion de startup")
    private Description description;

    @Embedded
    @Column(name = "approach")
    private Approach approach;

    @Enumerated(EnumType.STRING)
    @Column(name = "hiring_status")
    private HiringStatus hiringStatus;

    @Embedded
    @Column(name = "workers_count")
    private WorkersAmmount workers;

    public Startup() {
        super();
    }

    public Startup(String firstname, String lastName, String email, String dni, String password, 
                  String age, UserRoles userRole, String profession, String startupname, Description description, Approach approach, 
                  HiringStatus hiringStatus, WorkersAmmount workers) {
        super(firstname, lastName, email, dni, password, age, userRole, profession);
        this.name = startupname;
        this.description = description;
        this.approach = approach;
        this.hiringStatus = hiringStatus;
        this.workers = workers;
    }

    public Startup(CreateStartupCommand command) {
        super(command.firstname(), command.lastName(), command.email(), command.dni(), 
            command.password(), command.age(), command.userRole(), command.profession());
    }

    public Startup(String firstname, String lastName, String email, String dni, String password, String age,
            String profession, String StartupName2, DescriptionCommand Description2,
            HiringStatus hiringStatus2, WorkersAmmountCommand workers2) {
    }

    public Description getDescription() {
        return description;
    }

    public Approach getApproach() {
        return approach;
    }

    public HiringStatus getHiringStatus() {
        return hiringStatus;
    }

    public WorkersAmmount getWorkers() {
        return workers;
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
    public void setRole(UserRoles role) {
        this.userRole = role;
    }


    public void setDescription(Description description) {
        this.description = description;
    }
    public void setApproach(Approach approach) {
        this.approach = approach;
    }

    public void setHiringStatus(HiringStatus hiringStatus) {
        this.hiringStatus = hiringStatus;
    }
    public void setWorkers(WorkersAmmount workers) {
        this.workers = workers;
    }

    
}

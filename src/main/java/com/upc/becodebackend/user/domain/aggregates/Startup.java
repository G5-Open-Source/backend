/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.domain.aggregates;

import com.upc.becodebackend.user.domain.commands.CreateStartupCommand;
import com.upc.becodebackend.user.domain.commands.DescriptionCommand;
import com.upc.becodebackend.user.domain.commands.WorkersAmmountCommand;
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
public class Startup extends BaseUser {

    String StartupName;

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
                  String age, String profession, String startupname, Description description, Approach approach, 
                  HiringStatus hiringStatus, WorkersAmmount workers) {
        super(firstname, lastName, email, dni, password, age, profession);
        this.StartupName = startupname;
        this.description = description;
        this.approach = approach;
        this.hiringStatus = hiringStatus;
        this.workers = workers;
    }

    public Startup(CreateStartupCommand command) {
        super(command.firstname(), command.lastName(), command.email(), command.dni(), 
            command.password(), command.age(), command.profession());
        
    }
    
    public Startup(String firstname, String lastName, String email, String dni, String password, String age,
            String profession, String StartupName2, DescriptionCommand Description2,
            HiringStatus hiringStatus2, WorkersAmmountCommand workers2) {
    }

    public String getName(){
        return StartupName;
    }

}

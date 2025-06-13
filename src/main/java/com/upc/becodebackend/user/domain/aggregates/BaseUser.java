/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.domain.aggregates;

import com.upc.becodebackend.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import com.upc.becodebackend.user.domain.valueobjects.Age;
import com.upc.becodebackend.user.domain.valueobjects.Dni;
import com.upc.becodebackend.user.domain.valueobjects.EmailUser;
import com.upc.becodebackend.user.domain.valueobjects.Password;
import com.upc.becodebackend.user.domain.valueobjects.Profession;
import com.upc.becodebackend.user.domain.valueobjects.UserName;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Rodrigo Liberato
 */

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "user_type", discriminatorType = DiscriminatorType.STRING)
public class BaseUser extends AuditableAbstractAggregateRoot<BaseUser> {
    @Embedded
    UserName FullName;

    @Embedded
    EmailUser Email;

    @Embedded
    Dni DNI;

    @Embedded
    Password Password;
    
    @Embedded
    Age Age;

    @Embedded
    Profession Profession;


    public BaseUser(){
    }

    public BaseUser(String firstname, String lastName, String email, String dni, String password, String age, String Profession){
        this.FullName = new UserName(firstname, lastName);
        this.Email = new EmailUser(email);
        this.DNI = new Dni(dni);
        this.Password = new Password(password);
        this.Age = new Age(age);
        this.Profession = new Profession(Profession);
    }

    public String getFullName(){
        return FullName.getFullName();
    }
    public String getEmailUser(){
        return Email.email();
    }
    public String getDni(){
        return DNI.DNI();
    }
    public String getPassworde(){
        return Password.password();
    }
    public String getProfession(){
        return Profession.profession();
    }
    public String getAge(){
        return Age.age();
    }
    
    


}

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
public abstract class BaseUser<T extends BaseUser<T>> extends AuditableAbstractAggregateRoot<T> {
    @Embedded
    UserName fullName;

    @Embedded
    EmailUser email;

    @Embedded
    Dni dni;

    @Embedded
    Password password;

    @Embedded
    Age age;

    @Embedded
    Profession profession;

    public BaseUser(){
    }

    public BaseUser(String firstname, String lastName, String email, String dni, String password, String age, String Profession){
        this.fullName = new UserName(firstname, lastName);
        this.email = new EmailUser(email);
        this.dni = new Dni(dni);
        this.password = new Password(password);
        this.age = new Age(age);
        this.profession = new Profession(Profession);
    }

    public String getFullName(){
        return fullName.getFullName();
    }
    public String getEmailUser(){
        return email.email();
    }
    public String getDni(){
        return dni.DNI();
    }
    public String getPassworde(){
        return password.password();
    }
    public String getProfession(){
        return profession.profession();
    }
    public String getAge(){
        return age.age();
    }
    @Override
    public String getId() {
        return super.getId();
    }



}

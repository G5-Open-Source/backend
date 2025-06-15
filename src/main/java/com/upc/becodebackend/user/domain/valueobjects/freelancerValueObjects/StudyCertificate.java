/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects;

import java.util.Date;

import jakarta.persistence.Embeddable;

/**
 *
 * @author Rodrigo Liberato
 */
@Embeddable
public record StudyCertificate(String Name, String Description, Date AdquisitionDate) {
    public StudyCertificate() {this(null,null,null);}

    public StudyCertificate{
        if (Name == null || Name.isBlank()){
            throw new IllegalArgumentException("Name for certificate is required");
        }
        if (Description == null || Description.isBlank()){
            throw new IllegalArgumentException("Description for certificate is required");
        }
        if (AdquisitionDate == null){
            throw new IllegalArgumentException("AdquisitionDate for certificate is required");
        }
    }

    public String GetStudyCertificate(){
        return String.format("%s %s", Name, Description, AdquisitionDate);
    }

}

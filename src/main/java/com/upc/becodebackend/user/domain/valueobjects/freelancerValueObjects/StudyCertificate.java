/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

/**
 *
 * @author Rodrigo Liberato
 */
@Embeddable
public class StudyCertificate {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "adquisition_date", nullable = false, columnDefinition = "DATETIME")
    private Date adquisitionDate;

    public StudyCertificate() {
    }

    public StudyCertificate(String name, String description, Date adquisitionDate) {
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Name is required");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("Description is required");
        if (adquisitionDate == null) throw new IllegalArgumentException("AdquisitionDate is required");

        this.name = name;
        this.description = description;
        this.adquisitionDate = adquisitionDate;
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Date getAdquisitionDate() { return adquisitionDate; }

    public String getStudyCertificate() {
        return String.format("%s %s", name, description, adquisitionDate);
    }
}

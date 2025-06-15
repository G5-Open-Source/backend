/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest.resources;

import java.util.List;

import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.AveragePayPerHour;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.StudyCertificate;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.WorkingStatus;

/**
 *
 * @author 51924
 */
public record FreelancerResource(String freelancerid,
    String fullName,
    String email,
    String dni,
    String password,
    String age,
    String profession,
    List<StudyCertificate> studyCertificates,
    WorkingStatus workingStatus,
    AveragePayPerHour AveragePayment) {


}

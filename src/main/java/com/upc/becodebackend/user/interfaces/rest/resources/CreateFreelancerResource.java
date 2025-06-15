/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest.resources;

import java.util.List;

import com.upc.becodebackend.user.domain.commands.AveragePayPerHourCommand;
import com.upc.becodebackend.user.domain.commands.StudyCertificateCommand;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.WorkingStatus;

/**
 *
 * @author 51924
 */
public record CreateFreelancerResource(String firstname,
    String lastName,
    String email,
    String dni,
    String password,
    String age,
    String profession,
    List<StudyCertificateCommand> studyCertificates,
    WorkingStatus workingStatus,
    AveragePayPerHourCommand AveragePayment) {

}

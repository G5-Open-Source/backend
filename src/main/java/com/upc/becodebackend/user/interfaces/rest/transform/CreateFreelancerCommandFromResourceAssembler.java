/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest.transform;

import com.upc.becodebackend.user.domain.commands.CreateFreelancerCommand;
import com.upc.becodebackend.user.interfaces.rest.resources.CreateFreelancerResource;

/**
 *
 * @author 51924
 */
public class CreateFreelancerCommandFromResourceAssembler {
    public static CreateFreelancerCommand toCommandFromResource(CreateFreelancerResource resource){
        return new CreateFreelancerCommand(resource.firstname(), 
        resource.lastName(), 
        resource.email(), 
        resource.dni(), 
        resource.password(), 
        resource.age(), 
        resource.profession(), 
        resource.studyCertificates(), 
        resource.workingStatus(), 
        resource.averagePayPerHour());
    }

}

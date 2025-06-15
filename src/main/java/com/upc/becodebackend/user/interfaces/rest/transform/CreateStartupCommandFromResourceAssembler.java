/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest.transform;

import com.upc.becodebackend.user.domain.commands.CreateStartupCommand;
import com.upc.becodebackend.user.interfaces.rest.resources.CreateStartupResource;

/**
 *
 * @author 51924
 */
public class CreateStartupCommandFromResourceAssembler {
    public static CreateStartupCommand toCommandFromResource(CreateStartupResource resource){
        return new CreateStartupCommand(resource.firstName(), 
        resource.lastName(), 
        resource.email(), 
        resource.dni(), 
        resource.password(), 
        resource.age(), 
        resource.profession(), 
        resource.StartupName(), 
        resource.description(), 
        resource.approach(),
        resource.hiringStatus(), 
        resource.workers());
    }
}

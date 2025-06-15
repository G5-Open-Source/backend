/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest.transform;

import com.upc.becodebackend.user.domain.aggregates.Startup;
import com.upc.becodebackend.user.interfaces.rest.resources.StartupResource;

/**
 *
 * @author 51924
 */
public class StartupResourceFromEntityAssembler {
    public static StartupResource toResourceFromEntity(Startup entity){
        return new StartupResource(entity.getId(), entity.getFullName(), entity.getEmailUser(), entity.getDni(), entity.getPassworde(), entity.getAge(), entity.getProfession(), entity.getFullName(),entity.getDescription(), entity.getApproach(),entity.getHiringStatus(), entity.getWorkers());
    }
}

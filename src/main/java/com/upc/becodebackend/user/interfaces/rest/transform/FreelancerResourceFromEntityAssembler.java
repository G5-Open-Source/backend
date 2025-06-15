/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest.transform;

import com.upc.becodebackend.user.domain.aggregates.Freelancer;
import com.upc.becodebackend.user.interfaces.rest.resources.FreelancerResource;

/**
 *
 * @author 51924
 */
public class FreelancerResourceFromEntityAssembler {
    public static FreelancerResource toResourceFromEntity(Freelancer entity){
        return new FreelancerResource(entity.getId(), entity.getFullName(), entity.getEmailUser(), entity.getDni(), entity.getPassworde(), entity.getAge(), entity.getProfession(), entity.getStudyCertificates(),entity.getWorkingStatus(), entity.getAveragePayPerHour());
    }
}

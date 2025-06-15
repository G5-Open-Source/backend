/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest.resources;

import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.Approach;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.Description;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.HiringStatus;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.WorkersAmmount;

/**
 *
 * @author 51924
 */
public record StartupResource(String startupid,
    String fullName,
    String email,
    String dni,
    String password,
    String age,
    String profession,
    String StartupName,
    Description description,
    Approach approach,
    HiringStatus hiringStatus,
    WorkersAmmount workers) {

}

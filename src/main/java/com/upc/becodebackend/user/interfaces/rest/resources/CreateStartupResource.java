/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest.resources;

import com.upc.becodebackend.user.domain.commands.ApproachCommand;
import com.upc.becodebackend.user.domain.commands.DescriptionCommand;
import com.upc.becodebackend.user.domain.commands.WorkersAmmountCommand;
import com.upc.becodebackend.user.domain.valueobjects.UserRoles;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.HiringStatus;

/**
 *
 * @author 51924
 */
public record CreateStartupResource(
    String firstName,
    String lastName,
    String email,
    String dni,
    String password,
    String age,
    UserRoles userRole,
    String profession,
    String StartupName,
    DescriptionCommand description,
    ApproachCommand approach,
    HiringStatus hiringStatus,
    WorkersAmmountCommand workers) {

}

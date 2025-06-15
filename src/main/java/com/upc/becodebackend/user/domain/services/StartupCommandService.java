/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.upc.becodebackend.user.domain.services;

import java.util.Optional;

import com.upc.becodebackend.user.domain.aggregates.Startup;
import com.upc.becodebackend.user.domain.commands.CreateStartupCommand;
import com.upc.becodebackend.user.domain.commands.DeleteStartupCommand;
import com.upc.becodebackend.user.domain.commands.UpdateStartupCommand;

/**
 *
 * @author 51924
 */
public interface StartupCommandService {
    Optional<Startup> handle(CreateStartupCommand command);
    Optional<Startup> handle(UpdateStartupCommand command);
    void handle(DeleteStartupCommand command);
}

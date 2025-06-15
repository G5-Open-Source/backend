/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.upc.becodebackend.user.domain.services;

import java.util.Optional;

import com.upc.becodebackend.user.domain.aggregates.Freelancer;
import com.upc.becodebackend.user.domain.commands.CreateFreelancerCommand;
import com.upc.becodebackend.user.domain.commands.DeleteFreelancerCommand;
import com.upc.becodebackend.user.domain.commands.UpdateFreelancerCommand;

/**
 *
 * @author 51924
 */
public interface FreelancerCommandService {
    Optional<Freelancer> handle(CreateFreelancerCommand command);
    Optional<Freelancer> handle(UpdateFreelancerCommand command);
    void  handle(DeleteFreelancerCommand command);
}

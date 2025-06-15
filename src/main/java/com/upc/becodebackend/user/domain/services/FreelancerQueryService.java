/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.upc.becodebackend.user.domain.services;

import java.util.List;
import java.util.Optional;

import com.upc.becodebackend.user.domain.aggregates.Freelancer;
import com.upc.becodebackend.user.domain.queries.GetAllFreelancersQuery;
import com.upc.becodebackend.user.domain.queries.GetFreelancerByFullNameQuery;
import com.upc.becodebackend.user.domain.queries.GetFreelancerByIdQuery;

/**
 *
 * @author 51924
 */
public interface FreelancerQueryService {
    List<Freelancer> handle(GetAllFreelancersQuery query);
    Optional<Freelancer> handle(GetFreelancerByFullNameQuery query);
    Optional<Freelancer> handle(GetFreelancerByIdQuery query);
}

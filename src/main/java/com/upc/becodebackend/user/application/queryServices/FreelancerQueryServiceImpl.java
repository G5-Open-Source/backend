/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.application.queryServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.upc.becodebackend.user.domain.aggregates.Freelancer;
import com.upc.becodebackend.user.domain.queries.GetAllFreelancersQuery;
import com.upc.becodebackend.user.domain.queries.GetFreelancerByFullNameQuery;
import com.upc.becodebackend.user.domain.queries.GetFreelancerByIdQuery;
import com.upc.becodebackend.user.domain.services.FreelancerQueryService;
import com.upc.becodebackend.user.infrastructure.persistence.jpa.repositories.FreelancerRepository;

/**
 *
 * @author 51924
 */
@Service
public class FreelancerQueryServiceImpl implements FreelancerQueryService {

    private final FreelancerRepository freelancerRepository;

    private FreelancerQueryServiceImpl(FreelancerRepository freelancerRepository){
        this.freelancerRepository = freelancerRepository;
    }

    @Override
    public List<Freelancer> handle(GetAllFreelancersQuery query){
        return this.freelancerRepository.findAll();
    }

    @Override
    public Optional<Freelancer> handle(GetFreelancerByFullNameQuery query){
        return this.freelancerRepository.findByFullName_FirstNameAndFullName_LastName(
        query.Name().firstName(),
        query.Name().lastName()
    );
    }

    @Override
    public Optional<Freelancer> handle(GetFreelancerByIdQuery query){
        return this.freelancerRepository.findById(query.Id());
    }

}

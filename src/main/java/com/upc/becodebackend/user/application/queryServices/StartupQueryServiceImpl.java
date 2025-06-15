/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.application.queryServices;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.upc.becodebackend.user.domain.aggregates.Startup;
import com.upc.becodebackend.user.domain.queries.GetAllStartupsQuery;
import com.upc.becodebackend.user.domain.queries.GetStartupById;
import com.upc.becodebackend.user.domain.queries.GetStartupByName;
import com.upc.becodebackend.user.domain.services.StartupQueryService;
import com.upc.becodebackend.user.infrastructure.persistence.jpa.repositories.StartupRepository;

/**
 *
 * @author 51924
 */
@Service
public class StartupQueryServiceImpl implements StartupQueryService{
    private final StartupRepository startupRepository;

    private StartupQueryServiceImpl(StartupRepository startupRepository){
        this.startupRepository = startupRepository;
    }

    @Override
    public List<Startup> handle(GetAllStartupsQuery query){
        return this.startupRepository.findAll();
    }

    @Override
    public Optional<Startup> handle(GetStartupByName query){
        return this.startupRepository.findByName(query.StartupName());
    }

    @Override
    public Optional<Startup> handle(GetStartupById query){
        return this.startupRepository.findById(query.Id());
    }


}

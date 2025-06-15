/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.interfaces.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upc.becodebackend.user.domain.queries.GetAllFreelancersQuery;
import com.upc.becodebackend.user.domain.queries.GetAllStartupsQuery;
import com.upc.becodebackend.user.domain.queries.GetFreelancerByIdQuery;
import com.upc.becodebackend.user.domain.queries.GetStartupById;
import com.upc.becodebackend.user.domain.services.FreelancerCommandService;
import com.upc.becodebackend.user.domain.services.FreelancerQueryService;
import com.upc.becodebackend.user.domain.services.StartupCommandService;
import com.upc.becodebackend.user.domain.services.StartupQueryService;
import com.upc.becodebackend.user.interfaces.rest.resources.CreateFreelancerResource;
import com.upc.becodebackend.user.interfaces.rest.resources.CreateStartupResource;
import com.upc.becodebackend.user.interfaces.rest.resources.FreelancerResource;
import com.upc.becodebackend.user.interfaces.rest.resources.StartupResource;
import com.upc.becodebackend.user.interfaces.rest.transform.CreateFreelancerCommandFromResourceAssembler;
import com.upc.becodebackend.user.interfaces.rest.transform.CreateStartupCommandFromResourceAssembler;
import com.upc.becodebackend.user.interfaces.rest.transform.FreelancerResourceFromEntityAssembler;
import com.upc.becodebackend.user.interfaces.rest.transform.StartupResourceFromEntityAssembler;



@RestController
@RequestMapping(value="/api/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final StartupQueryService startupQueryService;
    private final StartupCommandService startupCommandService;
    private final FreelancerQueryService freelancerQueryService;
    private final FreelancerCommandService freelancerCommandService;

    public UserController(StartupQueryService startupQueryService,
                            StartupCommandService startupCommandService,
                            FreelancerQueryService freelancerQueryService,
                            FreelancerCommandService freelancerCommandService) {
        this.startupQueryService = startupQueryService;
        this.startupCommandService = startupCommandService;
        this.freelancerQueryService = freelancerQueryService;
        this.freelancerCommandService = freelancerCommandService;
    }

    @PostMapping
    public ResponseEntity<FreelancerResource> createFreelancer(@RequestBody CreateFreelancerResource resource) {
        var createFreelancerCommand = CreateFreelancerCommandFromResourceAssembler.toCommandFromResource(resource);
        var freelancer = freelancerCommandService.handle(createFreelancerCommand);

        if(freelancer.isEmpty()) return ResponseEntity.badRequest().build();

        var freelancerResource = FreelancerResourceFromEntityAssembler.toResourceFromEntity(freelancer.get());

        return new ResponseEntity<>(freelancerResource, HttpStatus.CREATED);
    }
    
    @PostMapping
    public ResponseEntity<StartupResource> createStartup(@RequestBody CreateStartupResource resource) {
        var createStartupCommand = CreateStartupCommandFromResourceAssembler.toCommandFromResource(resource);
        var startup = startupCommandService.handle(createStartupCommand);

        if(startup.isEmpty()) return ResponseEntity.badRequest().build();

        var startupResource = StartupResourceFromEntityAssembler.toResourceFromEntity(startup.get());

        return new ResponseEntity<>(startupResource, HttpStatus.CREATED);
    }

    @GetMapping("/freelancers")
    public ResponseEntity<List<FreelancerResource>> getAllFreelancers(){ 
        var GetAllFreelancers = new GetAllFreelancersQuery();

        var freelancers = freelancerQueryService.handle(GetAllFreelancers);

        if(freelancers.isEmpty()) return ResponseEntity.badRequest().build();

       var freelancerResources = freelancers.stream()
        .map(FreelancerResourceFromEntityAssembler::toResourceFromEntity)
        .toList();
        return new ResponseEntity<>(freelancerResources, HttpStatus.OK);
    }

    @GetMapping("/startups")
    public ResponseEntity<List<StartupResource>> getAllStartups(){ 
        var getAllStartups= new GetAllStartupsQuery();

        var startups = startupQueryService.handle(getAllStartups);

        if(startups.isEmpty()) return ResponseEntity.badRequest().build();

       var startupsResources = startups.stream()
        .map(StartupResourceFromEntityAssembler::toResourceFromEntity)
        .toList();
        return new ResponseEntity<>(startupsResources, HttpStatus.OK);
    }

    @GetMapping("/freelancers/{freelancerId}")
    public ResponseEntity<FreelancerResource> getFreelancerById(@PathVariable String freelancerId){
        var getFreelancerById = new GetFreelancerByIdQuery(freelancerId);
        var freelancer = freelancerQueryService.handle(getFreelancerById);

        if(freelancer.isEmpty()) return ResponseEntity.badRequest().build();

        var freelancerResource = FreelancerResourceFromEntityAssembler.toResourceFromEntity(freelancer.get());

        return ResponseEntity.ok(freelancerResource);
    }

    @GetMapping("/startups/{startupsId}")
    public ResponseEntity<StartupResource> getStartupsById(@PathVariable String startupsId){
        var getStartupsById = new GetStartupById(startupsId);
        var startup = startupQueryService.handle(getStartupsById);

        if(startup.isEmpty()) return ResponseEntity.badRequest().build();

        var startuprResource = StartupResourceFromEntityAssembler.toResourceFromEntity(startup.get());

        return ResponseEntity.ok(startuprResource);
    }






    
}

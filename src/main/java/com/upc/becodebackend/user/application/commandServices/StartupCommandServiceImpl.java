/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.application.commandServices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.upc.becodebackend.user.domain.aggregates.Startup;
import com.upc.becodebackend.user.domain.commands.CreateStartupCommand;
import com.upc.becodebackend.user.domain.commands.DeleteStartupCommand;
import com.upc.becodebackend.user.domain.commands.UpdateStartupCommand;
import com.upc.becodebackend.user.domain.services.StartupCommandService;
import com.upc.becodebackend.user.domain.valueobjects.EmailUser;
import com.upc.becodebackend.user.domain.valueobjects.Profession;
import com.upc.becodebackend.user.domain.valueobjects.UserName;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.Approach;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.Description;
import com.upc.becodebackend.user.domain.valueobjects.startupValueObjects.WorkersAmmount;
import com.upc.becodebackend.user.infrastructure.persistence.jpa.repositories.StartupRepository;

/**
 *
 * @author 51924
 */
@Service
public class StartupCommandServiceImpl implements StartupCommandService {

    private final StartupRepository startupRepository;
    
    public StartupCommandServiceImpl(StartupRepository startupRepository) {
        this.startupRepository = startupRepository;
    }

    @Override
    public Optional<Startup> handle(CreateStartupCommand command) {
         try {
            String StarupName = command.StartupName();
            startupRepository.findByName(StarupName).map(startup -> {
            throw new IllegalArgumentException("Startup with Name "+ StarupName + " already exists");
        });   

        var Startup = new Startup(command);
        var createdStartup = startupRepository.save(Startup);
        return Optional.of(createdStartup);

        } catch (IllegalArgumentException e) {
            throw e;
        
        } 
        catch (Exception e) {
            throw new RuntimeException("Error creating Startup: " + e.getMessage(), e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Optional<Startup> handle(UpdateStartupCommand command) {
         try {
            var Startup = startupRepository.findById(command.StartupId())
                .orElseThrow(() -> new IllegalArgumentException(
                    "Startup with ID " + command.StartupId() + " not found"));

            if (command.email() != null && !command.email().equals(Startup.getEmailUser())) {
                var newEmail = new EmailUser(command.email());
                var existingWithEmail = startupRepository.findByEmail(newEmail);

                if (((Optional<Startup>) existingWithEmail).isPresent() && 
                    !((Optional<Startup>) existingWithEmail).get().getId().equals(Startup.getId())) {
                    throw new IllegalArgumentException("Email " + command.email() + " is already in use");
                }
            }

            if (command.firstname() != null) {
                Startup.setFullName(new UserName(command.firstname(), Startup.getFullName().split(" ")[1]));
            }
            
            if (command.lastName() != null) {
                String firstName = Startup.getFullName().split(" ")[0];
                Startup.setFullName(new UserName(firstName, command.lastName()));
            }

            if (command.email() != null) {
                Startup.setEmail(new EmailUser(command.email()));
            }

            if (command.profession() != null) {
                Startup.setProfession(new Profession(command.profession()));
            }

            if (command.description() != null) {
                Startup.setDescription(new Description(command.description().Description()));
            }

            if (command.approach() != null) {
                Startup.setApproach(new Approach(command.approach().Approach()));
            }
            
            if (command.approach() != null) {
                Startup.setApproach(new Approach(command.approach().Approach()));
            }
            if (command.hiringStatus() != null) {
                Startup.setHiringStatus(command.hiringStatus());
            }
            if (command.workers() != null) {
                Startup.setWorkers(new WorkersAmmount(command.workers().WorkersAmmount()));
            }

            var updatedStartup = startupRepository.save(Startup);
            return Optional.of(updatedStartup);

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error updating freelancer: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(DeleteStartupCommand command) {
        try {
            var startup = startupRepository.findById(command.StartupId()).orElseThrow(() -> new IllegalArgumentException(
                    "Startup with ID " + command.StartupId() + " not found"));

            if (startup.isInactive()) {
                throw new IllegalArgumentException(
                    "Startup with ID " + command.StartupId() + " is already deleted");
            }

            startup.markAsDeleted();
            startupRepository.save(startup);
            
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting Startup: " + e.getMessage(), e);
        }
    }

}

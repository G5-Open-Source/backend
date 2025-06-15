/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.upc.becodebackend.user.application.commandServices;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.upc.becodebackend.user.domain.aggregates.Freelancer;
import com.upc.becodebackend.user.domain.commands.CreateFreelancerCommand;
import com.upc.becodebackend.user.domain.commands.DeleteFreelancerCommand;
import com.upc.becodebackend.user.domain.commands.StudyCertificateCommand;
import com.upc.becodebackend.user.domain.commands.UpdateFreelancerCommand;
import com.upc.becodebackend.user.domain.services.FreelancerCommandService;
import com.upc.becodebackend.user.domain.valueobjects.Dni;
import com.upc.becodebackend.user.domain.valueobjects.EmailUser;
import com.upc.becodebackend.user.domain.valueobjects.Profession;
import com.upc.becodebackend.user.domain.valueobjects.UserName;
import com.upc.becodebackend.user.domain.valueobjects.freelancerValueObjects.AveragePayPerHour;
import com.upc.becodebackend.user.infrastructure.persistence.jpa.repositories.FreelancerRepository;

/**
 *
 * @author 51924
 */
@Service
public class FreelancerCommandServiceImpl implements FreelancerCommandService{

    private final FreelancerRepository freelancerRepository;

    public FreelancerCommandServiceImpl(FreelancerRepository freelancerRepository) {
        this.freelancerRepository = freelancerRepository;
    }

    @Override
    public Optional<Freelancer> handle(CreateFreelancerCommand command) {
        try {
            var email = new EmailUser(command.email());
        freelancerRepository.findByEmail(email).map(freelancer -> {
            throw new IllegalArgumentException("Profile with email "+ email.email() + " already exists");
        });
        
        var dni = new Dni(command.dni());
            freelancerRepository.findByDni(dni).map(freelancer ->{
                throw new IllegalArgumentException("Profile with email "+ dni.DNI() + " already exists");
            });    

        var Freelancer = new Freelancer(command);
        var createdFreelancer = freelancerRepository.save(Freelancer);
        return Optional.of(createdFreelancer);

        } catch (IllegalArgumentException e) {
            throw e;
        
        } 
        catch (Exception e) {
            throw new RuntimeException("Error creating freelancer: " + e.getMessage(), e);
        }
    }

    @Override
    public Optional<Freelancer> handle(UpdateFreelancerCommand command) {
        try {
            var freelancer = freelancerRepository.findById(command.FreelancerId())
                .orElseThrow(() -> new IllegalArgumentException(
                    "Freelancer with ID " + command.FreelancerId() + " not found"));

            if (command.email() != null && !command.email().equals(freelancer.getEmailUser())) {
                var newEmail = new EmailUser(command.email());
                var existingWithEmail = freelancerRepository.findByEmail(newEmail);
                if (existingWithEmail.isPresent() && 
                    !existingWithEmail.get().getId().equals(freelancer.getId())) {
                    throw new IllegalArgumentException("Email " + command.email() + " is already in use");
                }
            }

            if (command.firstname() != null) {
                freelancer.setFullName(new UserName(command.firstname(), freelancer.getFullName().split(" ")[1]));
            }
            
            if (command.lastName() != null) {
                String firstName = freelancer.getFullName().split(" ")[0];
                freelancer.setFullName(new UserName(firstName, command.lastName()));
            }

            if (command.email() != null) {
                freelancer.setEmail(new EmailUser(command.email()));
            }

            if (command.profession() != null) {
                freelancer.setProfession(new Profession(command.profession()));
            }

            if (command.workingStatus() != null) {
                freelancer.setWorkingStatus(command.workingStatus());
            }

            if (command.averagePayPerHour() != null) {
                freelancer.setAveragePayPerHour(new AveragePayPerHour(command.averagePayPerHour().payment()));
            }
            if (command.studyCertificates() != null) {
                freelancer.getStudyCertificates().clear();
                for (StudyCertificateCommand certCommand : command.studyCertificates()) {
                    freelancer.addStudyCertificateFromCommand(certCommand);
                }
            }
            var updatedFreelancer = freelancerRepository.save(freelancer);
            return Optional.of(updatedFreelancer);

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error updating freelancer: " + e.getMessage(), e);
        }
    }

    @Override
    public void handle(DeleteFreelancerCommand command) {
        try {
            var freelancer = freelancerRepository.findById(command.FreelancerId())
                .orElseThrow(() -> new IllegalArgumentException(
                    "Freelancer with ID " + command.FreelancerId() + " not found"));

            if (freelancer.isInactive()) {
                throw new IllegalArgumentException(
                    "Freelancer with ID " + command.FreelancerId() + " is already deleted");
            }

            freelancer.markAsDeleted();
            freelancerRepository.save(freelancer);
            
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error deleting freelancer: " + e.getMessage(), e);
        }
    }
    public void handleHardDelete(DeleteFreelancerCommand command) {
        try {
            var freelancer = freelancerRepository.findById(command.FreelancerId())
                .orElseThrow(() -> new IllegalArgumentException(
                    "Freelancer with ID " + command.FreelancerId() + " not found"));

            freelancerRepository.delete(freelancer);
            
        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new RuntimeException("Error hard deleting freelancer: " + e.getMessage(), e);
        }
    }

    public Optional<Freelancer> restoreFreelancer(String freelancerId) {
        try {
            var freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new IllegalArgumentException(
                    "Freelancer with ID " + freelancerId + " not found"));

            if (freelancer.isActive()) {
                throw new IllegalArgumentException(
                    "Freelancer with ID " + freelancerId + " is already active");
            }

            freelancer.restore();
            var restoredFreelancer = freelancerRepository.save(freelancer);
            
            return Optional.of(restoredFreelancer);
            
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Error restoring freelancer: " + e.getMessage(), e);
        }
    }

    public Optional<Freelancer> addCertificateToFreelancer(String freelancerId, StudyCertificateCommand certificateCommand) {
        try {
            var freelancer = freelancerRepository.findById(freelancerId)
                .orElseThrow(() -> new IllegalArgumentException(
                    "Freelancer with ID " + freelancerId + " not found"));

            freelancer.addStudyCertificateFromCommand(certificateCommand);
            var updatedFreelancer = freelancerRepository.save(freelancer);
            
            return Optional.of(updatedFreelancer);
            
        } catch (Exception e) {
            throw new RuntimeException("Error adding certificate to freelancer: " + e.getMessage(), e);
        }
    }
    

}

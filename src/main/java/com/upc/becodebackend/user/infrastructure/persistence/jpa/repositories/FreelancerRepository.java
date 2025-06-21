/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.upc.becodebackend.user.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.becodebackend.user.domain.aggregates.Freelancer;
/**
 *
 * @author 51924
 */
@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, String> {

    Optional<Freelancer> findByFullName_FirstNameAndFullName_LastName(String firstName, String lastName);

    Optional<Freelancer> findByEmail_Email(String email);

    Optional<Freelancer> findByDni_DNI(String dni);       
}


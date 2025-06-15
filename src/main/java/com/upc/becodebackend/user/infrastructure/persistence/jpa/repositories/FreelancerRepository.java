/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.upc.becodebackend.user.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.becodebackend.user.domain.aggregates.Freelancer;
import com.upc.becodebackend.user.domain.valueobjects.Dni;
import com.upc.becodebackend.user.domain.valueobjects.EmailUser;
import com.upc.becodebackend.user.domain.valueobjects.UserName;

/**
 *
 * @author 51924
 */
@Repository
public interface FreelancerRepository extends JpaRepository<Freelancer, String>{
    Optional<Freelancer> findByFullName(UserName userName);

    Optional<Freelancer> findByEmail(EmailUser email);

    Optional<Freelancer> findByDni(Dni dni);
    
}

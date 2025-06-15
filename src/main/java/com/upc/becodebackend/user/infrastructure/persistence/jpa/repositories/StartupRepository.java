/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.upc.becodebackend.user.infrastructure.persistence.jpa.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.upc.becodebackend.user.domain.aggregates.Startup;
import com.upc.becodebackend.user.domain.valueobjects.EmailUser;

/**
 *
 * @author 51924
 */
@Repository
public interface StartupRepository extends JpaRepository<Startup, String> {
    Optional<Startup> findByName(String startupName);

    Object findByEmail(EmailUser newEmail);
    
}

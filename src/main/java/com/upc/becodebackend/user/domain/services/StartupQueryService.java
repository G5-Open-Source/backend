/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.upc.becodebackend.user.domain.services;
import java.util.List;
import java.util.Optional;

import com.upc.becodebackend.user.domain.aggregates.Startup;
import com.upc.becodebackend.user.domain.queries.GetAllStartupsQuery;
import com.upc.becodebackend.user.domain.queries.GetStartupById;
import com.upc.becodebackend.user.domain.queries.GetStartupByName;

/**
 *
 * @author 51924
 */
public interface StartupQueryService {
    List<Startup> handle(GetAllStartupsQuery query);
    Optional<Startup> handle(GetStartupById query);
    Optional<Startup> handle(GetStartupByName query);
}

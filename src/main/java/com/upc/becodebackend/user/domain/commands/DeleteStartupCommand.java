/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.commands;

/**
 *
 * @author 51924
 */
public record DeleteStartupCommand(String StartupId) {
    public DeleteStartupCommand{
        if(StartupId == null){
            throw new IllegalArgumentException("Starup id cannot be null");
        }
    }
}

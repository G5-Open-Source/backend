/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Record.java to edit this template
 */

package com.upc.becodebackend.user.domain.commands;

import java.sql.Date;

/**
 *
 * @author Rodrigo Liberato
 */
public record StudyCertificateCommand(String name, String description, Date adquisitionDate) {

}

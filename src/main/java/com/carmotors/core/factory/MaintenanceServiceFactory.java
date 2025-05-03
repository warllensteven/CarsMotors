/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.factory;

import com.carmotors.maintenance.model.MaintenanceService;
import java.time.LocalDateTime;

/**
 *
 * @author camper
 */
public class MaintenanceServiceFactory {
     public static MaintenanceService createMaintenanceService(int vehicleId, String type, String description, double laborCost, String status, LocalDateTime startDate, LocalDateTime endDate, int technicianId) {
        return new MaintenanceService(vehicleId, type, description, laborCost, status, startDate, endDate, technicianId);
    }
}

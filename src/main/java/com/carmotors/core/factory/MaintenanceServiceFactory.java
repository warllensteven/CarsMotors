package com.carmotors.core.factory;

import com.carmotors.maintenance.model.MaintenanceService;
import java.time.LocalDateTime;

/**
 *
 * @author camper
 */
public class MaintenanceServiceFactory {
    public static MaintenanceService createMaintenanceService(
        int idClient,
        int vehicleId,
        String type,
        String description,
        double laborCost,
        String status,
        LocalDateTime startDate,
        LocalDateTime endDate,
        int technicianId
    ) {
        return new MaintenanceService(
            idClient,
            vehicleId,
            type,
            description,
            laborCost,
            status,
            startDate,
            endDate,
            technicianId
        );
    }
}

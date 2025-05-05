package com.carmotors.core.builder;

import com.carmotors.maintenance.model.MaintenanceService;
import java.time.LocalDateTime;

public class MaintenanceServiceBuilder {
    private int idClient;            // Nuevo campo
    private int vehicleId;
    private String type;
    private String description;
    private double laborCost;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int technicianId;

    public MaintenanceServiceBuilder setIdClient(int idClient) {
        this.idClient = idClient;
        return this;
    }

    public MaintenanceServiceBuilder setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public MaintenanceServiceBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public MaintenanceServiceBuilder setDescription(String description) {
        this.description = description;
        return this;
    }

    public MaintenanceServiceBuilder setLaborCost(double laborCost) {
        this.laborCost = laborCost;
        return this;
    }

    public MaintenanceServiceBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public MaintenanceServiceBuilder setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
        return this;
    }

    public MaintenanceServiceBuilder setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
        return this;
    }

    public MaintenanceServiceBuilder setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
        return this;
    }

    public MaintenanceService build() {
        return new MaintenanceService(idClient, vehicleId, type, description, laborCost, status, startDate, endDate, technicianId);
    }
}

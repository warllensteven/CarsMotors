package com.carmotors.maintenance.model;

import java.time.LocalDateTime;

public class MaintenanceService {
    private int id;
    private int vehicleId;
    private String type;
    private String description;
    private double laborCost;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int technicianId;

    public MaintenanceService(int id, int vehicleId, String type, String description, double laborCost,
            String status, LocalDateTime startDate, LocalDateTime endDate, int technicianId) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.type = type;
        this.description = description;
        this.laborCost = laborCost;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.technicianId = technicianId;
    }

    public MaintenanceService(int vehicleId, String type, String description, double laborCost,
            String status, LocalDateTime startDate, LocalDateTime endDate, int technicianId) {
        this.vehicleId = vehicleId;
        this.type = type;
        this.description = description;
        this.laborCost = laborCost;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.technicianId = technicianId;
    }

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }
}

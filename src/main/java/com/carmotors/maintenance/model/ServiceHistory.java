/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.maintenance.model;

/**
 *
 * @author warle
 */
import java.time.LocalDate;

public class ServiceHistory {

    private int id;
    private int vehicleId;
    private int maintenanceServiceId;
    private LocalDate date;
    private String description;

    public ServiceHistory(int id, int vehicleId, int maintenanceServiceId, LocalDate date, String description) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.maintenanceServiceId = maintenanceServiceId;
        this.date = date;
        this.description = description;
    }

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

    public int getMaintenanceServiceId() {
        return maintenanceServiceId;
    }

    public void setMaintenanceServiceId(int maintenanceServiceId) {
        this.maintenanceServiceId = maintenanceServiceId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

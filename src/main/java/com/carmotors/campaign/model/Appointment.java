/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.campaign.model;

import java.time.LocalDateTime;

/**
 *
 * @author warle
 */
public class Appointment {

    private int id;
    private int clientId;
    private int vehicleId;
    private int campaignId;
    private LocalDateTime appointmentDate;
    private String status;

    public Appointment(int id, int clientId, int vehicleId, int campaignId, LocalDateTime appointmentDate, String status) {
        this.id = id;
        this.clientId = clientId;
        this.vehicleId = vehicleId;
        this.campaignId = campaignId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public Appointment(int clientId, int vehicleId, int campaignId, LocalDateTime appointmentDate, String status) {
        this.clientId = clientId;
        this.vehicleId = vehicleId;
        this.campaignId = campaignId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    public LocalDateTime getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

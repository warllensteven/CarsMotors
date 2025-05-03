/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.builder;

import com.carmotors.campaign.model.Appointment;
import java.time.LocalDateTime;

/**
 *
 * @author camper
 */
public class AppointmentBuilder {
    private int clientId;
    private int vehicleId;
    private int campaignId;
    private LocalDateTime appointmentDate;
    private String status;

    public AppointmentBuilder setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public AppointmentBuilder setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
        return this;
    }

    public AppointmentBuilder setCampaignId(int campaignId) {
        this.campaignId = campaignId;
        return this;
    }

    public AppointmentBuilder setAppointmentDate(LocalDateTime appointmentDate) {
        this.appointmentDate = appointmentDate;
        return this;
    }

    public AppointmentBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public Appointment build() {
        return new Appointment(clientId, vehicleId, campaignId, appointmentDate, status);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.inspection.model;

import java.time.LocalDate;

/**
 *
 * @author warle
 */
public class InspectionSchedule {
    private int id;
    private int vehicleId;
    private LocalDate nextInspectionDate;
    private String reminderSent;

    public InspectionSchedule(int id, int vehicleId, LocalDate nextInspectionDate, String reminderSent) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.nextInspectionDate = nextInspectionDate;
        this.reminderSent = reminderSent;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }
    public LocalDate getNextInspectionDate() { return nextInspectionDate; }
    public void setNextInspectionDate(LocalDate nextInspectionDate) { this.nextInspectionDate = nextInspectionDate; }
    public String getReminderSent() { return reminderSent; }
    public void setReminderSent(String reminderSent) { this.reminderSent = reminderSent; }
}

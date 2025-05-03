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
public class TechnicalInspection {
    private int id;
    private int vehicleId;
    private LocalDate inspectionDate;
    private String result;
    private String notes;

    public TechnicalInspection(int id, int vehicleId, LocalDate inspectionDate, String result, String notes) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.inspectionDate = inspectionDate;
        this.result = result;
        this.notes = notes;
    }

    public TechnicalInspection(int vehicleId, LocalDate inspectionDate, String result, String notes) {
        this.vehicleId = vehicleId;
        this.inspectionDate = inspectionDate;
        this.result = result;
        this.notes = notes;
    }
    

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getVehicleId() { return vehicleId; }
    public void setVehicleId(int vehicleId) { this.vehicleId = vehicleId; }
    public LocalDate getInspectionDate() { return inspectionDate; }
    public void setInspectionDate(LocalDate inspectionDate) { this.inspectionDate = inspectionDate; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}

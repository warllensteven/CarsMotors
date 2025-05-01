/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.maintenance.model;

/**
 *
 * @author warle
 */
public class ServiceDetail {
    private int id;
    private int maintenanceServiceId;
    private int sparePartId;
    private int quantityUsed;

    public ServiceDetail(int id, int maintenanceServiceId, int sparePartId, int quantityUsed) {
        this.id = id;
        this.maintenanceServiceId = maintenanceServiceId;
        this.sparePartId = sparePartId;
        this.quantityUsed = quantityUsed;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getMaintenanceServiceId() { return maintenanceServiceId; }
    public void setMaintenanceServiceId(int maintenanceServiceId) { this.maintenanceServiceId = maintenanceServiceId; }
    public int getSparePartId() { return sparePartId; }
    public void setSparePartId(int sparePartId) { this.sparePartId = sparePartId; }
    public int getQuantityUsed() { return quantityUsed; }
    public void setQuantityUsed(int quantityUsed) { this.quantityUsed = quantityUsed; }
}


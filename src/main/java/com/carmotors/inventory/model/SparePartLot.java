/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.inventory.model;

/**
 *
 * @author warle
 */
import java.time.LocalDate;

public class SparePartLot {
    private int id;
    private int sparePartId;
    private String batchCode;
    private LocalDate entryDate;
    private int quantity;
    private int supplierId;

    public SparePartLot(int id, int sparePartId, String batchCode, LocalDate entryDate, int quantity, int supplierId) {
        this.id = id;
        this.sparePartId = sparePartId;
        this.batchCode = batchCode;
        this.entryDate = entryDate;
        this.quantity = quantity;
        this.supplierId = supplierId;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getSparePartId() { return sparePartId; }
    public void setSparePartId(int sparePartId) { this.sparePartId = sparePartId; }
    public String getBatchCode() { return batchCode; }
    public void setBatchCode(String batchCode) { this.batchCode = batchCode; }
    public LocalDate getEntryDate() { return entryDate; }
    public void setEntryDate(LocalDate entryDate) { this.entryDate = entryDate; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.stats.model;

/**
 *
 * @author camper
 */
public class InventoryUsageReport {
      private String sparePartName;
        private int quantityUsed;

    public InventoryUsageReport(String sparePartName, int quantityUsed) {
        this.sparePartName = sparePartName;
        this.quantityUsed = quantityUsed;
    }

    public String getSparePartName() {
        return sparePartName;
    }

    public int getQuantityUsed() {
        return quantityUsed;
    }
    
    
}

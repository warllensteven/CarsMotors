/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.builder;

import com.carmotors.inventory.model.PurchaseOrder;
import java.time.LocalDate;

/**
 *
 * @author camper
 */
public class PurchaseOrderBuilder {
    private int supplierId;
    private LocalDate orderDate;
    private String status;
    private double totalCost;

    public PurchaseOrderBuilder setSupplierId(int supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public PurchaseOrderBuilder setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public PurchaseOrderBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public PurchaseOrderBuilder setTotalCost(double totalCost) {
        this.totalCost = totalCost;
        return this;
    }

    public PurchaseOrder build() {
        return new PurchaseOrder(supplierId, orderDate, status, totalCost);
    }
}

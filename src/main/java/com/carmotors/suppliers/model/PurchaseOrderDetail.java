/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.suppliers.model;

/**
 *
 * @author warle
 */
public class PurchaseOrderDetail {
    private int id;
    private int purchaseOrderId;
    private int sparePartId;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    public PurchaseOrderDetail(int id, int purchaseOrderId, int sparePartId, int quantity, double unitPrice, double subtotal) {
        this.id = id;
        this.purchaseOrderId = purchaseOrderId;
        this.sparePartId = sparePartId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public PurchaseOrderDetail(int purchaseOrderId, int sparePartId, int quantity, double unitPrice, double subtotal) {
        this.purchaseOrderId = purchaseOrderId;
        this.sparePartId = sparePartId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(int purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId;
    }

    public int getSparePartId() {
        return sparePartId;
    }

    public void setSparePartId(int sparePartId) {
        this.sparePartId = sparePartId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }
}
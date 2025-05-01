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

public class PurchaseOrder {
    private int id;
    private int supplierId;
    private LocalDate orderDate;
    private String status;
    private double totalCost;

    public PurchaseOrder(int id, int supplierId, LocalDate orderDate, String status, double totalCost) {
        this.id = id;
        this.supplierId = supplierId;
        this.orderDate = orderDate;
        this.status = status;
        this.totalCost = totalCost;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getSupplierId() { return supplierId; }
    public void setSupplierId(int supplierId) { this.supplierId = supplierId; }
    public LocalDate getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDate orderDate) { this.orderDate = orderDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public double getTotalCost() { return totalCost; }
    public void setTotalCost(double totalCost) { this.totalCost = totalCost; }
}
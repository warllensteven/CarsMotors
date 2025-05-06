/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.invoice.model;

/**
 *
 * @author warle
 */
public class InvoiceDetail {
    private int id;
    private int invoiceId;
    private String description;
    private int quantity;
    private double unitPrice;
    private double subtotal;

    public InvoiceDetail(String description, double price) {
        this.description = description;
        this.unitPrice = price;
        this.quantity = 1;
        this.subtotal = this.unitPrice * this.quantity;
    }

    public InvoiceDetail(int id, int invoiceId, String description, int quantity, double unitPrice, double subtotal) {
        this.id = id;
        this.invoiceId = invoiceId;
        this.description = description;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

  public InvoiceDetail(int i, String descripcion, double costo) {
    this.invoiceId = i; // o puedes ignorarlo si aún no tienes el ID de la factura
    this.description = descripcion;
    this.unitPrice = costo;
    this.quantity = 1;
    this.subtotal = this.unitPrice * this.quantity;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
        this.subtotal = this.unitPrice * this.quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
        this.subtotal = this.unitPrice * this.quantity;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getPrice() {
        return getUnitPrice();
    }
}
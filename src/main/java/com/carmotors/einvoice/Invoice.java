/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.einvoice;

/**
 *
 * @author warle
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Invoice {
    private String invoiceNumber;
    private LocalDateTime date;
    private Client client;
    private List<Item> items;
    private double taxRate; // Por ejemplo, 19% IVA
    private double discount; // Descuento fijo en valor monetario

    public Invoice(String invoiceNumber, Client client, double taxRate, double discount) {
        this.invoiceNumber = invoiceNumber;
        this.date = LocalDateTime.now();
        this.client = client;
        this.items = new ArrayList<>();
        this.taxRate = taxRate;
        this.discount = discount;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double calculateSubtotal() {
        return items.stream().mapToDouble(Item::getTotalPrice).sum();
    }

    public double calculateTax() {
        return calculateSubtotal() * taxRate;
    }

    public double calculateTotal() {
        return calculateSubtotal() + calculateTax() - discount;
    }

    // Getters
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Client getClient() {
        return client;
    }

    public List<Item> getItems() {
        return items;
    }

    public double getTaxRate() {
        return taxRate;
    }

    public double getDiscount() {
        return discount;
    }
}

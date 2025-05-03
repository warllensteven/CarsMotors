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

public class SparePart {

    private int id;
    private String name;
    private String type; // Debería ser un enum, pero usaremos String por ahora con valores válidos
    private String brand;
    private String model;
    private int supplierId;
    private int stock;
    private int minStock;
    private LocalDate entryDate;
    private LocalDate expiryDate;
    private String status;

    public SparePart(int id, String name, String type, String brand, String model, int supplierId, int stock, int minStock, LocalDate entryDate, LocalDate expiryDate, String status) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.model = model;
        this.supplierId = supplierId;
        this.stock = stock;
        this.minStock = minStock;
        this.entryDate = entryDate;
        this.expiryDate = expiryDate;
        this.status = status;
    }
    public SparePart(String name, String type, String brand, String model, int supplierId, int stock, int minStock, LocalDate entryDate, LocalDate expiryDate, String status) {
    this.name = name;
    this.type = type;
    this.brand = brand;
    this.model = model;
    this.supplierId = supplierId;
    this.stock = stock;
    this.minStock = minStock;
    this.entryDate = entryDate;
    this.expiryDate = expiryDate;
    this.status = status;
}


    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
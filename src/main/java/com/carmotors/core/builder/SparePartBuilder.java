/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.builder;

import com.carmotors.inventory.model.SparePart;
import java.time.LocalDate;

/**
 *
 * @author camper
 */
public class SparePartBuilder {
    private String name;
    private String type;
    private String brand;
    private String model;
    private int supplierId;
    private int stock;
    private int minStock;
    private LocalDate entryDate;
    private LocalDate expiryDate;
    private String status;

    public SparePartBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SparePartBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public SparePartBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public SparePartBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public SparePartBuilder setSupplierId(int supplierId) {
        this.supplierId = supplierId;
        return this;
    }

    public SparePartBuilder setStock(int stock) {
        this.stock = stock;
        return this;
    }

    public SparePartBuilder setMinStock(int minStock) {
        this.minStock = minStock;
        return this;
    }

    public SparePartBuilder setEntryDate(LocalDate entryDate) {
        this.entryDate = entryDate;
        return this;
    }

    public SparePartBuilder setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
        return this;
    }

    public SparePartBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public SparePart build() {
        return new SparePart(name, type, brand, model, supplierId, stock, minStock, entryDate, expiryDate, status);
    }
}


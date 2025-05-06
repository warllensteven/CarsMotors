/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.builder;

import com.carmotors.suppliers.model.Supplier;

/**
 *
 * @author camper
 */
public class SupplierBuilder {
    private String name;
    private String nit;
    private String contact;
    private String visitFrequency;

    public SupplierBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public SupplierBuilder setNit(String nit) {
        this.nit = nit;
        return this;
    }

    public SupplierBuilder setContact(String contact) {
        this.contact = contact;
        return this;
    }

    public SupplierBuilder setVisitFrequency(String visitFrequency) {
        this.visitFrequency = visitFrequency;
        return this;
    }

    public Supplier build() {
        return new Supplier(name, nit, contact, visitFrequency);
    }
}

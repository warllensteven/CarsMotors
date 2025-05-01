/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.inventory.model;

/**
 *
 * @author warle
 */
public class Supplier {

    private int id;
    private String name;
    private String nit;
    private String contact;
    private String visitFrequency;

    public Supplier(int id, String name, String nit, String contact, String visitFrequency) {
        this.id = id;
        this.name = name;
        this.nit = nit;
        this.contact = contact;
        this.visitFrequency = visitFrequency;
    }

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

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getVisitFrequency() {
        return visitFrequency;
    }

    public void setVisitFrequency(String visitFrequency) {
        this.visitFrequency = visitFrequency;
    }
}

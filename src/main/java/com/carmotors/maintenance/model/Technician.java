/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.maintenance.model;

/**
 *
 * @author warle
 */
public class Technician {
    private int id;
    private String name;
    private String specialty;
    private String contact;

    public Technician(int id, String name, String specialty, String contact) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.contact = contact;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}
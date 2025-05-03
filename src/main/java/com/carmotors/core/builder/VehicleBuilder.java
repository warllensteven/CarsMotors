/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.carmotors.core.builder;



import com.carmotors.client.model.Vehicle;

/**
 *
 * @author camper
 */
public class VehicleBuilder {
    private int clientId;
    private String brand;
    private String model;
    private String plate;
    private String type;

    public VehicleBuilder setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public VehicleBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public VehicleBuilder setModel(String model) {
        this.model = model;
        return this;
    }

    public VehicleBuilder setPlate(String plate) {
        this.plate = plate;
        return this;
    }

    public VehicleBuilder setType(String type) {
        this.type = type;
        return this;
    }

    public Vehicle build() {
        return new Vehicle(clientId, brand, model, plate, type);
    }
}

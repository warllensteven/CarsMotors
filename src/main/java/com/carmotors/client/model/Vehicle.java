package com.carmotors.client.model;

public class Vehicle {
    private int id;
    private int clientId;
    private String brand;
    private String model;
    private String plate;
    private String type;

    // Constructor adecuado para crear un vehículo
    public Vehicle(int clientId, String brand, String model, String plate, String type) {
        this.clientId = clientId;
        this.brand = brand;
        this.model = model;
        this.plate = plate;
        this.type = type;
    }

    // Métodos getter y setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
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

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

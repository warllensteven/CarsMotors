/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.factory;

import com.carmotors.client.model.Vehicle;

/**
 *
 * @author camper
 */
public class VehicleFactory {
    public static Vehicle createVehicle(int clientId, String brand, String model, String plate, String type) {
        return new Vehicle(clientId, brand, model, plate, type);
    }
}

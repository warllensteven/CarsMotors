package com.carmotors.client.controller;

import com.carmotors.client.dao.VehicleDAO;
import com.carmotors.client.model.Vehicle;
import java.sql.SQLException;

public class VehicleController {

    private static VehicleController instance;

    private VehicleController() {
        // Constructor privado para Singleton
    }

    public static VehicleController getInstance() {
        if (instance == null) {
            instance = new VehicleController();
        }
        return instance;
    }

    public void add(Vehicle vehicle) throws SQLException {
        VehicleDAO.getInstance().add(vehicle);
    }

    public Vehicle getById(int id) throws SQLException {
        return VehicleDAO.getInstance().getById(id);
    }

    public void update(Vehicle vehicle) throws SQLException {
        VehicleDAO.getInstance().update(vehicle);
    }

    public void delete(int id) throws SQLException {
        VehicleDAO.getInstance().delete(id);
    }
}

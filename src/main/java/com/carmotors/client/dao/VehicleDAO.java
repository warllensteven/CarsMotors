/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.client.dao;

/**
 *
 * @author warle
 */
import com.carmotors.client.model.Vehicle;
import com.carmotors.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    private static VehicleDAO instance;

    private VehicleDAO() {
        // Constructor privado para Singleton
    }

    public static VehicleDAO getInstance() {
        if (instance == null) {
            instance = new VehicleDAO();
        }
        return instance;
    }

    public void add(Vehicle vehicle) throws SQLException {
        String query = "INSERT INTO vehicles (client_id, brand, model, plate, type) VALUES (?, ?, ?, ?, ?)";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, vehicle.getClientId());
            stmt.setString(2, vehicle.getBrand());
            stmt.setString(3, vehicle.getModel());
            stmt.setString(4, vehicle.getPlate());
            stmt.setString(5, vehicle.getType());
            int affectedRows = stmt.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Falló la inserción del vehículo, no se afectaron filas.");
            }

            // Obtener el ID generado
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    vehicle.setId(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("No se pudo obtener el ID generado.");
                }
            }
        }
    }

    public Vehicle getById(int id) throws SQLException {
        String query = "SELECT * FROM vehicles WHERE id = ?";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Vehicle(
                                                rs.getString("brand"),
                        rs.getString("model"),
                        rs.getString("plate"),
                        rs.getString("type")
                    );
                }
            }
        }
        return null;
    }

    public List<Vehicle> getAll() throws SQLException {
        List<Vehicle> vehicles = new ArrayList<>();
        String query = "SELECT * FROM vehicles";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                                        rs.getString("brand"),
                    rs.getString("model"),
                    rs.getString("plate"),
                    rs.getString("type")
                );
                vehicles.add(vehicle);
            }
        }
        return vehicles;
    }

    public void update(Vehicle vehicle) throws SQLException {
        String query = "UPDATE vehicles SET client_id = ?, brand = ?, model = ?, plate = ?, type = ? WHERE id = ?";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, vehicle.getClientId());
            stmt.setString(2, vehicle.getBrand());
            stmt.setString(3, vehicle.getModel());
            stmt.setString(4, vehicle.getPlate());
            stmt.setString(5, vehicle.getType());
            stmt.setInt(6, vehicle.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM vehicles WHERE id = ?";
        Connection conn = DatabaseConnection.getInstance().getConnection();
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.maintenance.dao;

/**
 *
 * @author warle
 */
import com.carmotors.database.DatabaseConnection;
import com.carmotors.maintenance.model.MaintenanceService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceServiceDAO {
    private static MaintenanceServiceDAO instance;

    private MaintenanceServiceDAO() {
        // Constructor privado para Singleton
    }

    public static MaintenanceServiceDAO getInstance() {
        if (instance == null) {
            instance = new MaintenanceServiceDAO();
        }
        return instance;
    }

    public void add(MaintenanceService service) throws SQLException {
        String query = "INSERT INTO maintenance_services (vehicle_id, type, description, labor_cost, status, start_date, end_date, technician_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, service.getVehicleId());
            stmt.setString(2, service.getType());
            stmt.setString(3, service.getDescription());
            stmt.setDouble(4, service.getLaborCost());
            stmt.setString(5, service.getStatus());
            stmt.setObject(6, service.getStartDate());
            stmt.setObject(7, service.getEndDate());
            stmt.setInt(8, service.getTechnicianId());
            stmt.executeUpdate();
        }
    }

    public MaintenanceService getById(int id) throws SQLException {
        String query = "SELECT * FROM maintenance_services WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new MaintenanceService(
                        rs.getInt("id"),
                        rs.getInt("vehicle_id"),
                        rs.getString("type"),
                        rs.getString("description"),
                        rs.getDouble("labor_cost"),
                        rs.getString("status"),
                        rs.getObject("start_date", LocalDateTime.class),
                        rs.getObject("end_date", LocalDateTime.class),
                        rs.getInt("technician_id")
                    );
                }
            }
        }
        return null;
    }

    public List<MaintenanceService> getAll() throws SQLException {
        List<MaintenanceService> services = new ArrayList<>();
        String query = "SELECT * FROM maintenance_services";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                MaintenanceService service = new MaintenanceService(
                    rs.getInt("id"),
                    rs.getInt("vehicle_id"),
                    rs.getString("type"),
                    rs.getString("description"),
                    rs.getDouble("labor_cost"),
                    rs.getString("status"),
                    rs.getObject("start_date", LocalDateTime.class),
                    rs.getObject("end_date", LocalDateTime.class),
                    rs.getInt("technician_id")
                );
                services.add(service);
            }
        }
        return services;
    }

    public void update(MaintenanceService service) throws SQLException {
        String query = "UPDATE maintenance_services SET vehicle_id = ?, type = ?, description = ?, labor_cost = ?, status = ?, start_date = ?, end_date = ?, technician_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, service.getVehicleId());
            stmt.setString(2, service.getType());
            stmt.setString(3, service.getDescription());
            stmt.setDouble(4, service.getLaborCost());
            stmt.setString(5, service.getStatus());
            stmt.setObject(6, service.getStartDate());
            stmt.setObject(7, service.getEndDate());
            stmt.setInt(8, service.getTechnicianId());
            stmt.setInt(9, service.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM maintenance_services WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

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
import com.carmotors.maintenance.model.ServiceHistory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ServiceHistoryDAO {
    private static ServiceHistoryDAO instance;

    private ServiceHistoryDAO() {
        // Constructor privado para Singleton
    }

    public static ServiceHistoryDAO getInstance() {
        if (instance == null) {
            instance = new ServiceHistoryDAO();
        }
        return instance;
    }

    public void add(ServiceHistory history) throws SQLException {
        String query = "INSERT INTO service_history (vehicle_id, maintenance_service_id, date, description) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, history.getVehicleId());
            stmt.setInt(2, history.getMaintenanceServiceId());
            stmt.setObject(3, history.getDate());
            stmt.setString(4, history.getDescription());
            stmt.executeUpdate();
        }
    }

    public ServiceHistory getById(int id) throws SQLException {
        String query = "SELECT * FROM service_history WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ServiceHistory(
                        rs.getInt("id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("maintenance_service_id"),
                        rs.getObject("date", LocalDate.class),
                        rs.getString("description")
                    );
                }
            }
        }
        return null;
    }

    public List<ServiceHistory> getAll() throws SQLException {
        List<ServiceHistory> histories = new ArrayList<>();
        String query = "SELECT * FROM service_history";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ServiceHistory history = new ServiceHistory(
                    rs.getInt("id"),
                    rs.getInt("vehicle_id"),
                    rs.getInt("maintenance_service_id"),
                    rs.getObject("date", LocalDate.class),
                    rs.getString("description")
                );
                histories.add(history);
            }
        }
        return histories;
    }

    public void update(ServiceHistory history) throws SQLException {
        String query = "UPDATE service_history SET vehicle_id = ?, maintenance_service_id = ?, date = ?, description = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, history.getVehicleId());
            stmt.setInt(2, history.getMaintenanceServiceId());
            stmt.setObject(3, history.getDate());
            stmt.setString(4, history.getDescription());
            stmt.setInt(5, history.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM service_history WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

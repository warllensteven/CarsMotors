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
import com.carmotors.maintenance.model.ServiceDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceDetailDAO {
    private static ServiceDetailDAO instance;

    private ServiceDetailDAO() {
        // Constructor privado para Singleton
    }

    public static ServiceDetailDAO getInstance() {
        if (instance == null) {
            instance = new ServiceDetailDAO();
        }
        return instance;
    }

    public void add(ServiceDetail detail) throws SQLException {
        String query = "INSERT INTO service_details (maintenance_service_id, spare_part_id, quantity_used) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, detail.getMaintenanceServiceId());
            stmt.setInt(2, detail.getSparePartId());
            stmt.setInt(3, detail.getQuantityUsed());
            stmt.executeUpdate();
        }
    }

    public ServiceDetail getById(int id) throws SQLException {
        String query = "SELECT * FROM service_details WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new ServiceDetail(
                        rs.getInt("id"),
                        rs.getInt("maintenance_service_id"),
                        rs.getInt("spare_part_id"),
                        rs.getInt("quantity_used")
                    );
                }
            }
        }
        return null;
    }

    public List<ServiceDetail> getAll() throws SQLException {
        List<ServiceDetail> details = new ArrayList<>();
        String query = "SELECT * FROM service_details";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                ServiceDetail detail = new ServiceDetail(
                    rs.getInt("id"),
                    rs.getInt("maintenance_service_id"),
                    rs.getInt("spare_part_id"),
                    rs.getInt("quantity_used")
                );
                details.add(detail);
            }
        }
        return details;
    }

    public void update(ServiceDetail detail) throws SQLException {
        String query = "UPDATE service_details SET maintenance_service_id = ?, spare_part_id = ?, quantity_used = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, detail.getMaintenanceServiceId());
            stmt.setInt(2, detail.getSparePartId());
            stmt.setInt(3, detail.getQuantityUsed());
            stmt.setInt(4, detail.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM service_details WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

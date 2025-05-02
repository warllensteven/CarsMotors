/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.inspection.dao;

/**
 *
 * @author warle
 */
import com.carmotors.database.DatabaseConnection;
import com.carmotors.inspection.model.TechnicalInspection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TechnicalInspectionDAO {
    private static TechnicalInspectionDAO instance;

    private TechnicalInspectionDAO() {
        // Constructor privado para Singleton
    }

    public static TechnicalInspectionDAO getInstance() {
        if (instance == null) {
            instance = new TechnicalInspectionDAO();
        }
        return instance;
    }

    public void add(TechnicalInspection inspection) throws SQLException {
        String query = "INSERT INTO technical_inspections (vehicle_id, inspection_date, result, notes) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, inspection.getVehicleId());
            stmt.setObject(2, inspection.getInspectionDate());
            stmt.setString(3, inspection.getResult());
            stmt.setString(4, inspection.getNotes());
            stmt.executeUpdate();
        }
    }

    public TechnicalInspection getById(int id) throws SQLException {
        String query = "SELECT * FROM technical_inspections WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new TechnicalInspection(
                        rs.getInt("id"),
                        rs.getInt("vehicle_id"),
                        rs.getObject("inspection_date", LocalDate.class),
                        rs.getString("result"),
                        rs.getString("notes")
                    );
                }
            }
        }
        return null;
    }

    public List<TechnicalInspection> getAll() throws SQLException {
        List<TechnicalInspection> inspections = new ArrayList<>();
        String query = "SELECT * FROM technical_inspections";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                TechnicalInspection inspection = new TechnicalInspection(
                    rs.getInt("id"),
                    rs.getInt("vehicle_id"),
                    rs.getObject("inspection_date", LocalDate.class),
                    rs.getString("result"),
                    rs.getString("notes")
                );
                inspections.add(inspection);
            }
        }
        return inspections;
    }

    public void update(TechnicalInspection inspection) throws SQLException {
        String query = "UPDATE technical_inspections SET vehicle_id = ?, inspection_date = ?, result = ?, notes = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, inspection.getVehicleId());
            stmt.setObject(2, inspection.getInspectionDate());
            stmt.setString(3, inspection.getResult());
            stmt.setString(4, inspection.getNotes());
            stmt.setInt(5, inspection.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM technical_inspections WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
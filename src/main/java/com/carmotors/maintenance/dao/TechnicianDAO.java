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
import com.carmotors.maintenance.model.Technician;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnicianDAO {
    private static TechnicianDAO instance;

    private TechnicianDAO() {
        // Constructor privado para Singleton
    }

    public static TechnicianDAO getInstance() {
        if (instance == null) {
            instance = new TechnicianDAO();
        }
        return instance;
    }

    public void add(Technician technician) throws SQLException {
        String query = "INSERT INTO technicians (name, specialty, contact) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, technician.getName());
            stmt.setString(2, technician.getSpecialty());
            stmt.setString(3, technician.getContact());
            stmt.executeUpdate();
        }
    }

    public Technician getById(int id) throws SQLException {
        String query = "SELECT * FROM technicians WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Technician(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("specialty"),
                        rs.getString("contact")
                    );
                }
            }
        }
        return null;
    }

    public List<Technician> getAll() throws SQLException {
        List<Technician> technicians = new ArrayList<>();
        String query = "SELECT * FROM technicians";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Technician technician = new Technician(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("specialty"),
                    rs.getString("contact")
                );
                technicians.add(technician);
            }
        }
        return technicians;
    }

    public void update(Technician technician) throws SQLException {
        String query = "UPDATE technicians SET name = ?, specialty = ?, contact = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, technician.getName());
            stmt.setString(2, technician.getSpecialty());
            stmt.setString(3, technician.getContact());
            stmt.setInt(4, technician.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM technicians WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
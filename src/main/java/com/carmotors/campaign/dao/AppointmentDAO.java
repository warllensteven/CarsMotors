/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.campaign.dao;

/**
 *
 * @author warle
 */
import com.carmotors.database.DatabaseConnection;
import com.carmotors.campaign.model.Appointment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {
    private static AppointmentDAO instance;

    private AppointmentDAO() {
        // Constructor privado para Singleton
    }

    public static AppointmentDAO getInstance() {
        if (instance == null) {
            instance = new AppointmentDAO();
        }
        return instance;
    }

    public void add(Appointment appointment) throws SQLException {
        String query = "INSERT INTO appointments (client_id, vehicle_id, campaign_id, appointment_date, status) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, appointment.getClientId());
            stmt.setInt(2, appointment.getVehicleId());
            stmt.setInt(3, appointment.getCampaignId());
            stmt.setObject(4, appointment.getAppointmentDate());
            stmt.setString(5, appointment.getStatus());
            stmt.executeUpdate();
        }
    }

    public Appointment getById(int id) throws SQLException {
        String query = "SELECT * FROM appointments WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Appointment(
                        rs.getInt("id"),
                        rs.getInt("client_id"),
                        rs.getInt("vehicle_id"),
                        rs.getInt("campaign_id"),
                        rs.getObject("appointment_date", LocalDateTime.class),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public List<Appointment> getAll() throws SQLException {
        List<Appointment> appointments = new ArrayList<>();
        String query = "SELECT * FROM appointments";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Appointment appointment = new Appointment(
                    rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getInt("vehicle_id"),
                    rs.getInt("campaign_id"),
                    rs.getObject("appointment_date", LocalDateTime.class),
                    rs.getString("status")
                );
                appointments.add(appointment);
            }
        }
        return appointments;
    }

    public void update(Appointment appointment) throws SQLException {
        String query = "UPDATE appointments SET client_id = ?, vehicle_id = ?, campaign_id = ?, appointment_date = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, appointment.getClientId());
            stmt.setInt(2, appointment.getVehicleId());
            stmt.setInt(3, appointment.getCampaignId());
            stmt.setObject(4, appointment.getAppointmentDate());
            stmt.setString(5, appointment.getStatus());
            stmt.setInt(6, appointment.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM appointments WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

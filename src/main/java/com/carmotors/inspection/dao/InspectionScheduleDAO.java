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
import com.carmotors.inspection.model.InspectionSchedule;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InspectionScheduleDAO {
    private static InspectionScheduleDAO instance;

    private InspectionScheduleDAO() {
        // Constructor privado para Singleton
    }

    public static InspectionScheduleDAO getInstance() {
        if (instance == null) {
            instance = new InspectionScheduleDAO();
        }
        return instance;
    }

    public void add(InspectionSchedule schedule) throws SQLException {
        String query = "INSERT INTO inspection_schedules (vehicle_id, next_inspection_date, reminder_sent) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, schedule.getVehicleId());
            stmt.setObject(2, schedule.getNextInspectionDate());
            stmt.setString(3, schedule.getReminderSent());
            stmt.executeUpdate();
        }
    }

    public InspectionSchedule getById(int id) throws SQLException {
        String query = "SELECT * FROM inspection_schedules WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new InspectionSchedule(
                        rs.getInt("id"),
                        rs.getInt("vehicle_id"),
                        rs.getObject("next_inspection_date", LocalDate.class),
                        rs.getString("reminder_sent")
                    );
                }
            }
        }
        return null;
    }

    public List<InspectionSchedule> getAll() throws SQLException {
        List<InspectionSchedule> schedules = new ArrayList<>();
        String query = "SELECT * FROM inspection_schedules";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                InspectionSchedule schedule = new InspectionSchedule(
                    rs.getInt("id"),
                    rs.getInt("vehicle_id"),
                    rs.getObject("next_inspection_date", LocalDate.class),
                    rs.getString("reminder_sent")
                );
                schedules.add(schedule);
            }
        }
        return schedules;
    }

    public void update(InspectionSchedule schedule) throws SQLException {
        String query = "UPDATE inspection_schedules SET vehicle_id = ?, next_inspection_date = ?, reminder_sent = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, schedule.getVehicleId());
            stmt.setObject(2, schedule.getNextInspectionDate());
            stmt.setString(3, schedule.getReminderSent());
            stmt.setInt(4, schedule.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM inspection_schedules WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

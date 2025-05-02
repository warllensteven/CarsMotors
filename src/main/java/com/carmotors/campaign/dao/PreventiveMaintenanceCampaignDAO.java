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
import com.carmotors.campaign.model.PreventiveMaintenanceCampaign;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PreventiveMaintenanceCampaignDAO {
    private static PreventiveMaintenanceCampaignDAO instance;

    private PreventiveMaintenanceCampaignDAO() {
        // Constructor privado para Singleton
    }

    public static PreventiveMaintenanceCampaignDAO getInstance() {
        if (instance == null) {
            instance = new PreventiveMaintenanceCampaignDAO();
        }
        return instance;
    }

    public void add(PreventiveMaintenanceCampaign campaign) throws SQLException {
        String query = "INSERT INTO preventive_maintenance_campaigns (name, start_date, end_date, description, discount_percentage) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, campaign.getName());
            stmt.setObject(2, campaign.getStartDate());
            stmt.setObject(3, campaign.getEndDate());
            stmt.setString(4, campaign.getDescription());
            stmt.setDouble(5, campaign.getDiscountPercentage());
            stmt.executeUpdate();
        }
    }

    public PreventiveMaintenanceCampaign getById(int id) throws SQLException {
        String query = "SELECT * FROM preventive_maintenance_campaigns WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PreventiveMaintenanceCampaign(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getObject("start_date", LocalDate.class),
                        rs.getObject("end_date", LocalDate.class),
                        rs.getString("description"),
                        rs.getDouble("discount_percentage")
                    );
                }
            }
        }
        return null;
    }

    public List<PreventiveMaintenanceCampaign> getAll() throws SQLException {
        List<PreventiveMaintenanceCampaign> campaigns = new ArrayList<>();
        String query = "SELECT * FROM preventive_maintenance_campaigns";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PreventiveMaintenanceCampaign campaign = new PreventiveMaintenanceCampaign(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getObject("start_date", LocalDate.class),
                    rs.getObject("end_date", LocalDate.class),
                    rs.getString("description"),
                    rs.getDouble("discount_percentage")
                );
                campaigns.add(campaign);
            }
        }
        return campaigns;
    }

    public void update(PreventiveMaintenanceCampaign campaign) throws SQLException {
        String query = "UPDATE preventive_maintenance_campaigns SET name = ?, start_date = ?, end_date = ?, description = ?, discount_percentage = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, campaign.getName());
            stmt.setObject(2, campaign.getStartDate());
            stmt.setObject(3, campaign.getEndDate());
            stmt.setString(4, campaign.getDescription());
            stmt.setDouble(5, campaign.getDiscountPercentage());
            stmt.setInt(6, campaign.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM preventive_maintenance_campaigns WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
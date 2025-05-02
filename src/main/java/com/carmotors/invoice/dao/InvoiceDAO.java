/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.invoice.dao;

/**
 *
 * @author warle
 */
import com.carmotors.database.DatabaseConnection;
import com.carmotors.invoice.model.Invoice;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private static InvoiceDAO instance;

    private InvoiceDAO() {
        // Constructor privado para Singleton
    }

    public static InvoiceDAO getInstance() {
        if (instance == null) {
            instance = new InvoiceDAO();
        }
        return instance;
    }

    public void add(Invoice invoice) throws SQLException {
        String query = "INSERT INTO invoices (client_id, maintenance_service_id, issue_date, total, cufe, qr_code, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, invoice.getClientId());
            stmt.setInt(2, invoice.getMaintenanceServiceId());
            stmt.setObject(3, invoice.getIssueDate());
            stmt.setDouble(4, invoice.getTotal());
            stmt.setString(5, invoice.getCufe());
            stmt.setString(6, invoice.getQrCode());
            stmt.setString(7, invoice.getStatus());
            stmt.executeUpdate();
        }
    }

    public Invoice getById(int id) throws SQLException {
        String query = "SELECT * FROM invoices WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Invoice(
                        rs.getInt("id"),
                        rs.getInt("client_id"),
                        rs.getInt("maintenance_service_id"),
                        rs.getObject("issue_date", LocalDate.class),
                        rs.getDouble("total"),
                        rs.getString("cufe"),
                        rs.getString("qr_code"),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public List<Invoice> getAll() throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM invoices";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Invoice invoice = new Invoice(
                    rs.getInt("id"),
                    rs.getInt("client_id"),
                    rs.getInt("maintenance_service_id"),
                    rs.getObject("issue_date", LocalDate.class),
                    rs.getDouble("total"),
                    rs.getString("cufe"),
                    rs.getString("qr_code"),
                    rs.getString("status")
                );
                invoices.add(invoice);
            }
        }
        return invoices;
    }

    public void update(Invoice invoice) throws SQLException {
        String query = "UPDATE invoices SET client_id = ?, maintenance_service_id = ?, issue_date = ?, total = ?, cufe = ?, qr_code = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, invoice.getClientId());
            stmt.setInt(2, invoice.getMaintenanceServiceId());
            stmt.setObject(3, invoice.getIssueDate());
            stmt.setDouble(4, invoice.getTotal());
            stmt.setString(5, invoice.getCufe());
            stmt.setString(6, invoice.getQrCode());
            stmt.setString(7, invoice.getStatus());
            stmt.setInt(8, invoice.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM invoices WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
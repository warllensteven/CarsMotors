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
import com.carmotors.invoice.model.InvoiceDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDetailDAO {
    private static InvoiceDetailDAO instance;

    private InvoiceDetailDAO() {
        // Constructor privado para Singleton
    }

    public static InvoiceDetailDAO getInstance() {
        if (instance == null) {
            instance = new InvoiceDetailDAO();
        }
        return instance;
    }

    public void add(InvoiceDetail detail) throws SQLException {
        String query = "INSERT INTO invoice_details (invoice_id, description, quantity, unit_price, subtotal) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, detail.getInvoiceId());
            stmt.setString(2, detail.getDescription());
            stmt.setInt(3, detail.getQuantity());
            stmt.setDouble(4, detail.getUnitPrice());
            stmt.setDouble(5, detail.getSubtotal());
            stmt.executeUpdate();
        }
    }

    public InvoiceDetail getById(int id) throws SQLException {
        String query = "SELECT * FROM invoice_details WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new InvoiceDetail(
                        rs.getInt("id"),
                        rs.getInt("invoice_id"),
                        rs.getString("description"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price"),
                        rs.getDouble("subtotal")
                    );
                }
            }
        }
        return null;
    }

    public List<InvoiceDetail> getAll() throws SQLException {
        List<InvoiceDetail> details = new ArrayList<>();
        String query = "SELECT * FROM invoice_details";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                InvoiceDetail detail = new InvoiceDetail(
                    rs.getInt("id"),
                    rs.getInt("invoice_id"),
                    rs.getString("description"),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price"),
                    rs.getDouble("subtotal")
                );
                details.add(detail);
            }
        }
        return details;
    }

    public void update(InvoiceDetail detail) throws SQLException {
        String query = "UPDATE invoice_details SET invoice_id = ?, description = ?, quantity = ?, unit_price = ?, subtotal = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, detail.getInvoiceId());
            stmt.setString(2, detail.getDescription());
            stmt.setInt(3, detail.getQuantity());
            stmt.setDouble(4, detail.getUnitPrice());
            stmt.setDouble(5, detail.getSubtotal());
            stmt.setInt(6, detail.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM invoice_details WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

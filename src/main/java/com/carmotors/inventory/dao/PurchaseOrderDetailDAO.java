/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.inventory.dao;

/**
 *
 * @author warle
 */
import com.carmotors.database.DatabaseConnection;
import com.carmotors.inventory.model.PurchaseOrderDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderDetailDAO {
    private static PurchaseOrderDetailDAO instance;

    private PurchaseOrderDetailDAO() {
        // Constructor privado para Singleton
    }

    public static PurchaseOrderDetailDAO getInstance() {
        if (instance == null) {
            instance = new PurchaseOrderDetailDAO();
        }
        return instance;
    }

    public void add(PurchaseOrderDetail detail) throws SQLException {
        String query = "INSERT INTO purchase_order_details (purchase_order_id, spare_part_id, quantity, unit_price) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, detail.getPurchaseOrderId());
            stmt.setInt(2, detail.getSparePartId());
            stmt.setInt(3, detail.getQuantity());
            stmt.setDouble(4, detail.getUnitPrice());
            stmt.executeUpdate();
        }
    }

    public PurchaseOrderDetail getById(int id) throws SQLException {
        String query = "SELECT * FROM purchase_order_details WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PurchaseOrderDetail(
                        rs.getInt("id"),
                        rs.getInt("purchase_order_id"),
                        rs.getInt("spare_part_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price")
                    );
                }
            }
        }
        return null;
    }

    public List<PurchaseOrderDetail> getAll() throws SQLException {
        List<PurchaseOrderDetail> details = new ArrayList<>();
        String query = "SELECT * FROM purchase_order_details";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PurchaseOrderDetail detail = new PurchaseOrderDetail(
                    rs.getInt("id"),
                    rs.getInt("purchase_order_id"),
                    rs.getInt("spare_part_id"),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price")
                );
                details.add(detail);
            }
        }
        return details;
    }

    public void update(PurchaseOrderDetail detail) throws SQLException {
        String query = "UPDATE purchase_order_details SET purchase_order_id = ?, spare_part_id = ?, quantity = ?, unit_price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, detail.getPurchaseOrderId());
            stmt.setInt(2, detail.getSparePartId());
            stmt.setInt(3, detail.getQuantity());
            stmt.setDouble(4, detail.getUnitPrice());
            stmt.setInt(5, detail.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM purchase_order_details WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

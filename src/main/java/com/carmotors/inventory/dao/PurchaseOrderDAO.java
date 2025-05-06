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
import com.carmotors.inventory.model.PurchaseOrder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PurchaseOrderDAO {
    private static PurchaseOrderDAO instance;

    private PurchaseOrderDAO() {
        // Constructor privado para Singleton
    }

    public static PurchaseOrderDAO getInstance() {
        if (instance == null) {
            instance = new PurchaseOrderDAO();
        }
        return instance;
    }

    public void add(PurchaseOrder purchaseOrder) throws SQLException {
        String query = "INSERT INTO purchase_orders (supplier_id, order_date, status, total_cost) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, purchaseOrder.getSupplierId());
            stmt.setObject(2, purchaseOrder.getOrderDate());
            stmt.setString(3, purchaseOrder.getStatus());
            stmt.setDouble(4, purchaseOrder.getTotalCost());
            stmt.executeUpdate();
        }
    }

    public PurchaseOrder getById(int id) throws SQLException {
        String query = "SELECT * FROM purchase_orders WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new PurchaseOrder(
                        rs.getInt("id"),
                        rs.getInt("supplier_id"),
                        rs.getObject("order_date", LocalDate.class),
                        rs.getString("status"),
                        rs.getDouble("total_cost")
                    );
                }
            }
        }
        return null;
    }

    public List<PurchaseOrder> getAll() throws SQLException {
        List<PurchaseOrder> purchaseOrders = new ArrayList<>();
        String query = "SELECT * FROM purchase_orders";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                PurchaseOrder purchaseOrder = new PurchaseOrder(
                    rs.getInt("id"),
                    rs.getInt("supplier_id"),
                    rs.getObject("order_date", LocalDate.class),
                    rs.getString("status"),
                    rs.getDouble("total_cost")
                );
                purchaseOrders.add(purchaseOrder);
            }
        }
        return purchaseOrders;
    }

    public void update(PurchaseOrder purchaseOrder) throws SQLException {
        String query = "UPDATE purchase_orders SET supplier_id = ?, order_date = ?, status = ?, total_cost = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, purchaseOrder.getSupplierId());
            stmt.setObject(2, purchaseOrder.getOrderDate());
            stmt.setString(3, purchaseOrder.getStatus());
            stmt.setDouble(4, purchaseOrder.getTotalCost());
            stmt.setInt(5, purchaseOrder.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM purchase_orders WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

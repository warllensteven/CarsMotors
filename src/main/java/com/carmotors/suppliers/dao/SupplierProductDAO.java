/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.suppliers.dao;

/**
 *
 * @author warle
 */
import com.carmotors.database.DatabaseConnection;
import com.carmotors.suppliers.model.SupplierProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SupplierProductDAO {
    private static SupplierProductDAO instance;

    private SupplierProductDAO() {
        // Constructor privado para Singleton
    }

    public static SupplierProductDAO getInstance() {
        if (instance == null) {
            instance = new SupplierProductDAO();
        }
        return instance;
    }

    public void add(SupplierProduct supplierProduct) throws SQLException {
        String query = "INSERT INTO supplier_products (supplier_id, spare_part_id, supply_date, quantity, unit_price) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, supplierProduct.getSupplierId());
            stmt.setInt(2, supplierProduct.getSparePartId());
            stmt.setObject(3, supplierProduct.getSupplyDate());
            stmt.setInt(4, supplierProduct.getQuantity());
            stmt.setDouble(5, supplierProduct.getUnitPrice());
            stmt.executeUpdate();
        }
    }

    public SupplierProduct getById(int id) throws SQLException {
        String query = "SELECT * FROM supplier_products WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new SupplierProduct(
                        rs.getInt("id"),
                        rs.getInt("supplier_id"),
                        rs.getInt("spare_part_id"),
                        rs.getObject("supply_date", LocalDate.class),
                        rs.getInt("quantity"),
                        rs.getDouble("unit_price")
                    );
                }
            }
        }
        return null;
    }

    public List<SupplierProduct> getAll() throws SQLException {
        List<SupplierProduct> supplierProducts = new ArrayList<>();
        String query = "SELECT * FROM supplier_products";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                SupplierProduct supplierProduct = new SupplierProduct(
                    rs.getInt("id"),
                    rs.getInt("supplier_id"),
                    rs.getInt("spare_part_id"),
                    rs.getObject("supply_date", LocalDate.class),
                    rs.getInt("quantity"),
                    rs.getDouble("unit_price")
                );
                supplierProducts.add(supplierProduct);
            }
        }
        return supplierProducts;
    }

    public void update(SupplierProduct supplierProduct) throws SQLException {
        String query = "UPDATE supplier_products SET supplier_id = ?, spare_part_id = ?, supply_date = ?, quantity = ?, unit_price = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, supplierProduct.getSupplierId());
            stmt.setInt(2, supplierProduct.getSparePartId());
            stmt.setObject(3, supplierProduct.getSupplyDate());
            stmt.setInt(4, supplierProduct.getQuantity());
            stmt.setDouble(5, supplierProduct.getUnitPrice());
            stmt.setInt(6, supplierProduct.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM supplier_products WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

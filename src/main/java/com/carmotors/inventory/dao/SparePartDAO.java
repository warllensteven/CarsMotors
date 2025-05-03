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
import com.carmotors.inventory.model.SparePart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SparePartDAO {
    private static SparePartDAO instance;

    private SparePartDAO() {
        // Constructor privado para Singleton
    }

    public static SparePartDAO getInstance() {
        if (instance == null) {
            instance = new SparePartDAO();
        }
        return instance;
    }

public void add(SparePart sparePart) throws SQLException {
    String query = "INSERT INTO spare_parts (name, type, brand, model, supplier_id, stock, min_stock, entry_date, expiry_date, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    Connection conn = DatabaseConnection.getInstance().getConnection();
    try (PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, sparePart.getName());
        stmt.setString(2, sparePart.getType());
        stmt.setString(3, sparePart.getBrand());
        stmt.setString(4, sparePart.getModel());
        stmt.setInt(5, sparePart.getSupplierId());
        stmt.setInt(6, sparePart.getStock());
        stmt.setInt(7, sparePart.getMinStock());
        stmt.setObject(8, sparePart.getEntryDate());
        stmt.setObject(9, sparePart.getExpiryDate());
        stmt.setString(10, sparePart.getStatus());
        stmt.executeUpdate();

        // Obtener el ID generado
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                sparePart.setId(generatedKeys.getInt(1));
            }
        }
    }
}

    public SparePart getById(int id) throws SQLException {
        String query = "SELECT * FROM spare_parts WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new SparePart(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("brand"),
                        rs.getString("model"),
                        rs.getInt("supplier_id"),
                        rs.getInt("stock"),
                        rs.getInt("min_stock"),
                        rs.getObject("entry_date", LocalDate.class),
                        rs.getObject("expiry_date", LocalDate.class),
                        rs.getString("status")
                    );
                }
            }
        }
        return null;
    }

    public List<SparePart> getAll() throws SQLException {
        List<SparePart> spareParts = new ArrayList<>();
        String query = "SELECT * FROM spare_parts";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                SparePart sparePart = new SparePart(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("type"),
                    rs.getString("brand"),
                    rs.getString("model"),
                    rs.getInt("supplier_id"),
                    rs.getInt("stock"),
                    rs.getInt("min_stock"),
                    rs.getObject("entry_date", LocalDate.class),
                    rs.getObject("expiry_date", LocalDate.class),
                    rs.getString("status")
                );
                spareParts.add(sparePart);
            }
        }
        return spareParts;
    }

    public void update(SparePart sparePart) throws SQLException {
        String query = "UPDATE spare_parts SET name = ?, type = ?, brand = ?, model = ?, supplier_id = ?, stock = ?, min_stock = ?, entry_date = ?, expiry_date = ?, status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, sparePart.getName());
            stmt.setString(2, sparePart.getType());
            stmt.setString(3, sparePart.getBrand());
            stmt.setString(4, sparePart.getModel());
            stmt.setInt(5, sparePart.getSupplierId());
            stmt.setInt(6, sparePart.getStock());
            stmt.setInt(7, sparePart.getMinStock());
            stmt.setObject(8, sparePart.getEntryDate());
            stmt.setObject(9, sparePart.getExpiryDate());
            stmt.setString(10, sparePart.getStatus());
            stmt.setInt(11, sparePart.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM spare_parts WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
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
import com.carmotors.suppliers.model.Supplier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SupplierDAO {
    private static SupplierDAO instance;

    private SupplierDAO() {
        // Constructor privado para Singleton
    }

    public static SupplierDAO getInstance() {
        if (instance == null) {
            instance = new SupplierDAO();
        }
        return instance;
    }

    
    public void add(Supplier supplier) throws SQLException {
    String query = "INSERT INTO suppliers (name, nit, contact, visit_frequency) VALUES (?, ?, ?, ?)";
    Connection conn = DatabaseConnection.getInstance().getConnection();
    try (PreparedStatement stmt = conn.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
        stmt.setString(1, supplier.getName());
        stmt.setString(2, supplier.getNit());
        stmt.setString(3, supplier.getContact());
        stmt.setString(4, supplier.getVisitFrequency());
        stmt.executeUpdate();

        // Obtener el ID generado
        try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
            if (generatedKeys.next()) {
                supplier.setId(generatedKeys.getInt(1));
            }
        }
    }
}
    
    public Supplier getById(int id) throws SQLException {
        String query = "SELECT * FROM suppliers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Supplier(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("nit"),
                        rs.getString("contact"),
                        rs.getString("visit_frequency")
                    );
                }
            }
        }
        return null;
    }

    public List<Supplier> getAll() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        String query = "SELECT * FROM suppliers";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Supplier supplier = new Supplier(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("nit"),
                    rs.getString("contact"),
                    rs.getString("visit_frequency")
                );
                suppliers.add(supplier);
            }
        }
        return suppliers;
    }

    public void update(Supplier supplier) throws SQLException {
        String query = "UPDATE suppliers SET name = ?, nit = ?, contact = ?, visit_frequency = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, supplier.getName());
            stmt.setString(2, supplier.getNit());
            stmt.setString(3, supplier.getContact());
            stmt.setString(4, supplier.getVisitFrequency());
            stmt.setInt(5, supplier.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM suppliers WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

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
import com.carmotors.inventory.model.SparePartLot;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SparePartLotDAO {
    private static SparePartLotDAO instance;

    private SparePartLotDAO() {
        // Constructor privado para Singleton
    }

    public static SparePartLotDAO getInstance() {
        if (instance == null) {
            instance = new SparePartLotDAO();
        }
        return instance;
    }

    public void add(SparePartLot sparePartLot) throws SQLException {
        String query = "INSERT INTO spare_part_lots (spare_part_id, batch_code, entry_date, quantity, supplier_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sparePartLot.getSparePartId());
            stmt.setString(2, sparePartLot.getBatchCode());
            stmt.setObject(3, sparePartLot.getEntryDate());
            stmt.setInt(4, sparePartLot.getQuantity());
            stmt.setInt(5, sparePartLot.getSupplierId());
            stmt.executeUpdate();
        }
    }

    public SparePartLot getById(int id) throws SQLException {
        String query = "SELECT * FROM spare_part_lots WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new SparePartLot(
                        rs.getInt("id"),
                        rs.getInt("spare_part_id"),
                        rs.getString("batch_code"),
                        rs.getObject("entry_date", LocalDate.class),
                        rs.getInt("quantity"),
                        rs.getInt("supplier_id")
                    );
                }
            }
        }
        return null;
    }

    public List<SparePartLot> getAll() throws SQLException {
        List<SparePartLot> sparePartLots = new ArrayList<>();
        String query = "SELECT * FROM spare_part_lots";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                SparePartLot sparePartLot = new SparePartLot(
                    rs.getInt("id"),
                    rs.getInt("spare_part_id"),
                    rs.getString("batch_code"),
                    rs.getObject("entry_date", LocalDate.class),
                    rs.getInt("quantity"),
                    rs.getInt("supplier_id")
                );
                sparePartLots.add(sparePartLot);
            }
        }
        return sparePartLots;
    }

    public void update(SparePartLot sparePartLot) throws SQLException {
        String query = "UPDATE spare_part_lots SET spare_part_id = ?, batch_code = ?, entry_date = ?, quantity = ?, supplier_id = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, sparePartLot.getSparePartId());
            stmt.setString(2, sparePartLot.getBatchCode());
            stmt.setObject(3, sparePartLot.getEntryDate());
            stmt.setInt(4, sparePartLot.getQuantity());
            stmt.setInt(5, sparePartLot.getSupplierId());
            stmt.setInt(6, sparePartLot.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM spare_part_lots WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.stats.dao;

import com.carmotors.stats.model.InventoryUsageReport;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author camper
 */
public class InventoryUsageDAO {
    private final Connection connection;

    public InventoryUsageDAO(Connection connection) {
        this.connection = connection;
    }

    public List<InventoryUsageReport> getMostUsedParts() {
        List<InventoryUsageReport> list = new ArrayList<>();
        String sql = """
            SELECT sp.name, SUM(sd.quantity_used) AS total
            FROM service_details sd
            JOIN spare_parts sp ON sp.id = sd.spare_part_id
            GROUP BY sp.name
            ORDER BY total DESC
        """;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new InventoryUsageReport(
                    rs.getString("name"),
                    rs.getInt("total")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error en base de datos" +e);
        }

        return list;
    }
}

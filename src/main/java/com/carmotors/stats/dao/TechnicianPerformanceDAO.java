package com.carmotors.stats.dao;


import com.carmotors.stats.model.TechnicianPerformance;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author camper
 */
public class TechnicianPerformanceDAO {
    private final Connection connection;

    public TechnicianPerformanceDAO(Connection connection) {
        this.connection = connection;
    }

    public List<TechnicianPerformance> getPerformanceSummary() {
        List<TechnicianPerformance> result = new ArrayList<>();
        String sql = """
            SELECT t.name AS technician, COUNT(*) AS jobs, 
                   SUM(TIMESTAMPDIFF(HOUR, ms.start_date, ms.end_date)) AS hours
            FROM technicians t
            JOIN maintenance_services ms ON ms.technician_id = t.id
            WHERE ms.status = 'Completado'
            GROUP BY t.name
        """;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                result.add(new TechnicianPerformance(
                    rs.getString("technician"),
                    rs.getInt("jobs"),
                    rs.getDouble("hours")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error en base de datos" +e);
        }

        return result;
    }
}

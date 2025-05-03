/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.stats.dao;

import com.carmotors.stats.model.ServiceReport;
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
public class ServiceReportDAO {
    private final Connection connection;

    public ServiceReportDAO(Connection connection) {
        this.connection = connection;
    }

    public List<ServiceReport> getTopServiceTypes() {
        List<ServiceReport> list = new ArrayList<>();
        String sql = """
            SELECT type, COUNT(*) AS count
            FROM maintenance_services
            GROUP BY type
            ORDER BY count DESC
        """;

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new ServiceReport(
                    rs.getString("type"),
                    rs.getInt("count")
                ));
            }
        } catch (SQLException e) {
            System.err.println("Error en base de datos" +e);
        }
        return list;
    }
}

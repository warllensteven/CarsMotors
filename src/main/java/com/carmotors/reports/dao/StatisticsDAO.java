/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.reports.dao;

/**
 *
 * @author warle
 */
import com.carmotors.database.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StatisticsDAO {
    private static StatisticsDAO instance;

    private StatisticsDAO() {
        // Constructor privado para el patrón Singleton
    }

    public static synchronized StatisticsDAO getInstance() {
        if (instance == null) {
            instance = new StatisticsDAO();
        }
        return instance;
    }

    public Object[][] getServiceStatistics() throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT type AS service_type, COUNT(*) AS count FROM maintenance_services GROUP BY type";
        System.out.println("Ejecutando consulta: " + sql);
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        // Almacenar datos en una lista
        List<Object[]> dataList = new ArrayList<>();
        while (rs.next()) {
            String serviceType = rs.getString("service_type");
            int count = rs.getInt("count");
            System.out.println("Dato: " + serviceType + ", " + count);
            dataList.add(new Object[]{serviceType, count});
        }

        // Convertir la lista a un array
        Object[][] data = new Object[dataList.size()][2];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        System.out.println("Número de filas devueltas: " + dataList.size());

        stmt.close();
        DatabaseConnection.getInstance().closeConnection();
        return data;
    }
}
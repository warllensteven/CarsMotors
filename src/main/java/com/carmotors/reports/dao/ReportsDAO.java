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

public class ReportsDAO {
    private static ReportsDAO instance;

    private ReportsDAO() {
        // Constructor privado para el patrón Singleton
    }

    public static synchronized ReportsDAO getInstance() {
        if (instance == null) {
            instance = new ReportsDAO();
        }
        return instance;
    }

    public Object[][] getInventoryReport(String startDate, String endDate) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT name, type, stock, entry_date FROM spare_parts WHERE entry_date BETWEEN ? AND ?";
        System.out.println("Ejecutando consulta: " + sql + " con fechas " + startDate + " a " + endDate);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);
        ResultSet rs = stmt.executeQuery();

        // Almacenar datos en una lista
        List<Object[]> dataList = new ArrayList<>();
        while (rs.next()) {
            String name = rs.getString("name");
            String type = rs.getString("type");
            int stock = rs.getInt("stock");
            java.sql.Date entryDate = rs.getDate("entry_date");
            System.out.println("Dato: " + name + ", " + type + ", " + stock + ", " + entryDate);
            dataList.add(new Object[]{name, type, stock, entryDate});
        }

        // Convertir la lista a un array
        Object[][] data = new Object[dataList.size()][4];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        System.out.println("Número de filas devueltas: " + dataList.size());

        stmt.close();
        DatabaseConnection.getInstance().closeConnection();
        return data;
    }

    public Object[][] getMaintenanceReport(String startDate, String endDate) throws SQLException {
        Connection conn = DatabaseConnection.getInstance().getConnection();
        String sql = "SELECT ms.id, ms.type, c.name AS client_name, ms.start_date, ms.end_date " +
                     "FROM maintenance_services ms " +
                     "JOIN vehicles v ON ms.vehicle_id = v.id " +
                     "JOIN clients c ON v.client_id = c.id " +
                     "WHERE ms.start_date BETWEEN ? AND ?";
        System.out.println("Ejecutando consulta: " + sql + " con fechas " + startDate + " a " + endDate);
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, startDate);
        stmt.setString(2, endDate);
        ResultSet rs = stmt.executeQuery();

        // Almacenar datos en una lista
        List<Object[]> dataList = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String type = rs.getString("type");
            String clientName = rs.getString("client_name");
            java.sql.Date startDateValue = rs.getDate("start_date");
            java.sql.Date endDateValue = rs.getDate("end_date");
            System.out.println("Dato: " + id + ", " + type + ", " + clientName + ", " + startDateValue + ", " + endDateValue);
            dataList.add(new Object[]{id, type, clientName, startDateValue, endDateValue});
        }

        // Convertir la lista a un array
        Object[][] data = new Object[dataList.size()][5];
        for (int i = 0; i < dataList.size(); i++) {
            data[i] = dataList.get(i);
        }
        System.out.println("Número de filas devueltas: " + dataList.size());

        stmt.close();
        DatabaseConnection.getInstance().closeConnection();
        return data;
    }
}
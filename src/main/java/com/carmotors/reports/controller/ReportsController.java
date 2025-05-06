/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.reports.controller;

/**
 *
 * @author warle
 */
import com.carmotors.reports.dao.ReportsDAO;
import com.carmotors.reports.view.ReportsPanel;
import com.carmotors.reports.view.StatisticsReportPanel;
import com.carmotors.main.CarMotorsWorkshop;

import java.sql.SQLException;
import javax.swing.*;

public class ReportsController {

    private StatisticsReportPanel mainView;
    private ReportsPanel reportsPanel;
    private CarMotorsWorkshop mainFrame;

    public ReportsController(StatisticsReportPanel mainView, CarMotorsWorkshop mainFrame) {
        this.mainView = mainView;
        this.mainFrame = mainFrame;
    }

    public ReportsController(ReportsPanel reportsPanel) {
        this.reportsPanel = reportsPanel;
    }

    public void showReports() {
        reportsPanel = new ReportsPanel();
        mainFrame.ShowPanel(reportsPanel);
    }

    public void generateReport(String reportType, String startDate, String endDate) {
        try {
            ReportsDAO dao = ReportsDAO.getInstance();
            Object[][] data = null;
            String[] columns = null;

            switch (reportType) {
                case "Inventory Report":
                    data = dao.getInventoryReport(startDate, endDate);
                    columns = new String[]{"Name", "Type", "Stock Quantity", "Entry Date"};
                    break;
                case "Maintenance Report":
                    data = dao.getMaintenanceReport(startDate, endDate);
                    columns = new String[]{"ID", "Type", "Client Name", "Start Date", "End Date"};
                    break;
                default:
                    JOptionPane.showMessageDialog(reportsPanel, "Report type not supported.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
            }

            reportsPanel.updateTable(data, columns);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(reportsPanel, "Error generating report: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

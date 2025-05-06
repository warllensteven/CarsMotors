/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.reports.controller;

/**
 *
 * @author warle
 */
import com.carmotors.reports.dao.StatisticsDAO;
import com.carmotors.reports.view.StatisticsPanel;
import com.carmotors.reports.view.StatisticsReportPanel;
import com.carmotors.main.CarMotorsWorkshop;

import java.sql.SQLException;
import javax.swing.*;

public class StatisticsController {

    private final StatisticsReportPanel view;
    private final CarMotorsWorkshop mainFrame;

    public StatisticsController(StatisticsReportPanel view, CarMotorsWorkshop mainFrame) {
        this.view = view;
        this.mainFrame = mainFrame;
    }

    public void showStatistics() {
        try {
            StatisticsDAO dao = StatisticsDAO.getInstance();
            Object[][] serviceData = dao.getServiceStatistics();
            String[] serviceColumns = {"Service Type", "Count"};
            StatisticsPanel servicePanel = new StatisticsPanel(serviceData, serviceColumns);

            mainFrame.ShowPanel(servicePanel);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Error loading statistics: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

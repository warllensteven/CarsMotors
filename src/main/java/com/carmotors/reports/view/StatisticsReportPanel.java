package com.carmotors.reports.view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author warle
 */
import javax.swing.*;
import java.awt.*;
import com.carmotors.main.CarMotorsWorkshop;
import com.carmotors.reports.controller.StatisticsController;
import com.carmotors.reports.controller.ReportsController;

public class StatisticsReportPanel extends JPanel {
    private JButton statisticsButton;
    private JButton reportsButton;
    private CarMotorsWorkshop mainFrame;

    public StatisticsReportPanel(CarMotorsWorkshop mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(2, 1, 10, 10));
        setBackground(Color.WHITE);

        // Buttons
        statisticsButton = new JButton("Show Statistics");
        reportsButton = new JButton("Generate Reports");

        // Add buttons to the panel
        add(statisticsButton);
        add(reportsButton);

        // Initialize controllers
        StatisticsController statisticsController = new StatisticsController(this, mainFrame);
        ReportsController reportsController = new ReportsController(this, mainFrame);

        // Add action listeners
        statisticsButton.addActionListener(e -> statisticsController.showStatistics());
        reportsButton.addActionListener(e -> reportsController.showReports());
    }
}
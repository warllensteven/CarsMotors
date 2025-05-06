/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.reports.view;

/**
 *
 * @author warle
 */
import javax.swing.*;
import java.awt.*;

public class StatisticsPanel extends JPanel {
    private JTable statisticsTable;
    private JScrollPane scrollPane;

    public StatisticsPanel(Object[][] data, String[] columnNames) {
        setLayout(new BorderLayout());
        statisticsTable = new JTable(data, columnNames);
        scrollPane = new JScrollPane(statisticsTable);
        add(scrollPane, BorderLayout.CENTER);
    }
}

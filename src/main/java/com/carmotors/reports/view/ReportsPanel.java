/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.reports.view;

/**
 *
 * @author warle
 */
import com.carmotors.reports.controller.ReportsController;
import javax.swing.*;
import java.awt.*;

public class ReportsPanel extends JPanel {
    private JComboBox<String> reportTypeComboBox;
    private JTextField startDateField;
    private JTextField endDateField;
    private JButton generateButton;
    private JTable reportsTable;
    private JScrollPane scrollPane;

    public ReportsPanel() {
        setLayout(new BorderLayout(10, 10));

        // Filters panel
        JPanel filtersPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        reportTypeComboBox = new JComboBox<>(new String[]{"Inventory Report", "Maintenance Report", "Supplier Report"});
        startDateField = new JTextField("YYYY-MM-DD");
        endDateField = new JTextField("YYYY-MM-DD");
        generateButton = new JButton("Generate Report");

        filtersPanel.add(new JLabel("Report Type:"));
        filtersPanel.add(reportTypeComboBox);
        filtersPanel.add(new JLabel("Start Date:"));
        filtersPanel.add(startDateField);
        filtersPanel.add(new JLabel("End Date:"));
        filtersPanel.add(endDateField);

        // Button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(generateButton);

        // Table for reports (initially empty)
        reportsTable = new JTable(new Object[][]{}, new String[]{"Column 1", "Column 2", "Column 3"});
        scrollPane = new JScrollPane(reportsTable);

        // Add components to panel
        add(filtersPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Add action listener for generate button
        ReportsController controller = new ReportsController(this);
        generateButton.addActionListener(e -> controller.generateReport(
            (String) reportTypeComboBox.getSelectedItem(),
            startDateField.getText(),
            endDateField.getText()
        ));
    }

    public void updateTable(Object[][] data, String[] columnNames) {
        reportsTable.setModel(new javax.swing.table.DefaultTableModel(data, columnNames));
    }
}
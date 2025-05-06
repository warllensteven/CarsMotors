/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.suppliers.view;

/**
 *
 * @author warle
 */
import com.carmotors.suppliers.controller.SupplierController;
import com.carmotors.suppliers.dao.SupplierEvaluationDAO;
import com.carmotors.suppliers.model.SupplierEvaluation;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class PerformanceReportsPanel extends JPanel {
    private JTable performanceTable;
    private JButton backButton;

    public PerformanceReportsPanel(SupplierController controller) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        try {
            List<SupplierEvaluation> evaluations = SupplierEvaluationDAO.getInstance().getAll();
            String[] columnNames = {"ID", "Supplier ID", "Evaluation Date", "Punctuality", "Quality", "Cost", "Overall Score"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            for (SupplierEvaluation eval : evaluations) {
                model.addRow(new Object[]{
                    eval.getId(),
                    eval.getSupplierId(),
                    eval.getEvaluationDate(),
                    eval.getPunctualityScore(),
                    eval.getQualityScore(),
                    eval.getCostScore(),
                    eval.getOverallScore()
                });
            }

            performanceTable = new JTable(model);
            add(new JScrollPane(performanceTable), BorderLayout.CENTER);

            backButton = new JButton("Back");
            backButton.addActionListener(e -> controller.mainFrame.ShowPanel(new SupplierManagementPanel(controller.mainFrame)));
            add(backButton, BorderLayout.SOUTH);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading performance reports: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
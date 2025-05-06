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
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;

public class SupplierEvaluationFormPanel extends JPanel {
    private JTextField supplierIdField;
    private JSpinner punctualitySpinner;
    private JSpinner qualitySpinner;
    private JSpinner costSpinner;
    private JButton saveButton;
    private SupplierController controller;

    public SupplierEvaluationFormPanel(SupplierController controller) {
        this.controller = controller;
        setLayout(new GridLayout(5, 2, 10, 10));
        setBackground(Color.WHITE);

        // Campos del formulario
        add(new JLabel("Supplier ID:"));
        supplierIdField = new JTextField();
        add(supplierIdField);

        add(new JLabel("Punctuality (1-5):"));
        punctualitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        add(punctualitySpinner);

        add(new JLabel("Quality (1-5):"));
        qualitySpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        add(qualitySpinner);

        add(new JLabel("Cost (1-5):"));
        costSpinner = new JSpinner(new SpinnerNumberModel(1, 1, 5, 1));
        add(costSpinner);

        saveButton = new JButton("Save Evaluation");
        saveButton.addActionListener(e -> saveEvaluation());
        add(new JLabel(""));
        add(saveButton);
    }

    private void saveEvaluation() {
        try {
            int supplierId = Integer.parseInt(supplierIdField.getText());
            int punctuality = (int) punctualitySpinner.getValue();
            int quality = (int) qualitySpinner.getValue();
            int cost = (int) costSpinner.getValue();
            double overallScore = (punctuality + quality + cost) / 3.0;

            controller.saveSupplierEvaluation(supplierId, LocalDate.now(), punctuality, quality, cost, overallScore);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid Supplier ID.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
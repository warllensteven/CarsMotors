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

public class PurchaseOrderFormPanel extends JPanel {
    private JTextField supplierIdField;
    private JTextField totalCostField;
    private JComboBox<String> statusComboBox;
    private JButton saveButton;
    private SupplierController controller;

    public PurchaseOrderFormPanel(SupplierController controller) {
        this.controller = controller;
        setLayout(new GridLayout(4, 2, 10, 10));
        setBackground(Color.WHITE);

        add(new JLabel("Supplier ID:"));
        supplierIdField = new JTextField();
        add(supplierIdField);

        add(new JLabel("Status:"));
        statusComboBox = new JComboBox<>(new String[]{"Pendiente", "Completado"});
        add(statusComboBox);

        add(new JLabel("Total Cost:"));
        totalCostField = new JTextField();
        add(totalCostField);

        saveButton = new JButton("Save Order");
        saveButton.addActionListener(e -> savePurchaseOrder());
        add(new JLabel(""));
        add(saveButton);
    }

    private void savePurchaseOrder() {
        try {
            int supplierId = Integer.parseInt(supplierIdField.getText());
            double totalCost = Double.parseDouble(totalCostField.getText());
            String status = (String) statusComboBox.getSelectedItem();

            controller.savePurchaseOrder(supplierId, LocalDate.now(), status, totalCost);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid numbers for Supplier ID and Total Cost.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
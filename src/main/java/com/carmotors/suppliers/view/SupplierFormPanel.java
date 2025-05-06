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

public class SupplierFormPanel extends JPanel {
    private JTextField nameField;
    private JTextField nitField;
    private JTextField contactField;
    private JTextField visitFrequencyField;
    private JButton saveButton;
    private SupplierController controller;

    public SupplierFormPanel(SupplierController controller) {
        this.controller = controller;
        setLayout(new GridLayout(5, 2, 10, 10));
        setBackground(Color.WHITE);

        // Initialize components
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("NIT:"));
        nitField = new JTextField();
        add(nitField);

        add(new JLabel("Contact:"));
        contactField = new JTextField();
        add(contactField);

        add(new JLabel("Visit Frequency:"));
        visitFrequencyField = new JTextField();
        add(visitFrequencyField);

        saveButton = new JButton("Save Supplier");
        saveButton.addActionListener(e -> controller.saveSupplier(
            nameField.getText(),
            nitField.getText(),
            contactField.getText(),
            visitFrequencyField.getText()
        ));
        add(new JLabel(""));
        add(saveButton);
    }
}

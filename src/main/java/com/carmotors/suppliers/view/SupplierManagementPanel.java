/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.suppliers.view;

/**
 *
 * @author warle
 */
import com.carmotors.main.CarMotorsWorkshop;
import com.carmotors.suppliers.controller.SupplierController;

import javax.swing.*;
import java.awt.*;

public class SupplierManagementPanel extends JPanel {
    private final CarMotorsWorkshop mainFrame;
    private JButton registerSupplierButton;
    private JButton evaluateSupplierButton;
    private JButton viewSuppliedProductsButton;
    private JButton createPurchaseOrderButton;
    private JButton viewPerformanceReportsButton;

    public SupplierManagementPanel(CarMotorsWorkshop mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        setBackground(Color.WHITE);

        // Initialize buttons
        registerSupplierButton = new JButton("Register Supplier");
        evaluateSupplierButton = new JButton("Evaluate Supplier");
        viewSuppliedProductsButton = new JButton("View Supplied Products");
        createPurchaseOrderButton = new JButton("Create Purchase Order");
        viewPerformanceReportsButton = new JButton("View Performance Reports");

        // Add buttons to the panel
        add(registerSupplierButton);
        add(evaluateSupplierButton);
        add(viewSuppliedProductsButton);
        add(createPurchaseOrderButton);
        add(viewPerformanceReportsButton);

        // Initialize controller
        SupplierController controller = new SupplierController(this, mainFrame);

        // Add action listeners
        registerSupplierButton.addActionListener(e -> controller.showSupplierForm());
        evaluateSupplierButton.addActionListener(e -> controller.showEvaluationForm());
        viewSuppliedProductsButton.addActionListener(e -> controller.showSuppliedProducts());
        createPurchaseOrderButton.addActionListener(e -> controller.showPurchaseOrderForm());
        viewPerformanceReportsButton.addActionListener(e -> controller.showPerformanceReports());
    }

    public CarMotorsWorkshop getMainFrame() {
        return mainFrame;
    }
}
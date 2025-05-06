/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.suppliers.controller;

/**
 *
 * @author warle
 */
import com.carmotors.main.CarMotorsWorkshop;
import com.carmotors.suppliers.dao.SupplierDAO;
import com.carmotors.suppliers.model.Supplier;
import com.carmotors.suppliers.view.SupplierFormPanel;
import com.carmotors.suppliers.view.SupplierManagementPanel;

import javax.swing.*;
import java.sql.SQLException;

public class SupplierController {
    private SupplierManagementPanel view;
    private CarMotorsWorkshop mainFrame;
    private SupplierDAO supplierDAO;

    public SupplierController(SupplierManagementPanel view, CarMotorsWorkshop mainFrame) {
        this.view = view;
        this.mainFrame = mainFrame;
        this.supplierDAO = SupplierDAO.getInstance();
    }

    public void showSupplierForm() {
        SupplierFormPanel formPanel = new SupplierFormPanel(this);
        mainFrame.ShowPanel(formPanel);
    }

    public void showEvaluationForm() {
        JOptionPane.showMessageDialog(view, "Evaluation form not implemented yet.");
    }

    public void showSuppliedProducts() {
        JOptionPane.showMessageDialog(view, "Supplied products not implemented yet.");
    }

    public void showPurchaseOrderForm() {
        JOptionPane.showMessageDialog(view, "Purchase order form not implemented yet.");
    }

    public void showPerformanceReports() {
        JOptionPane.showMessageDialog(view, "Performance reports not implemented yet.");
    }

    public void saveSupplier(String name, String nit, String contact, String visitFrequency) {
        try {
            Supplier supplier = new Supplier(name, nit, contact, visitFrequency);
            supplierDAO.add(supplier);
            JOptionPane.showMessageDialog(view, "Supplier saved successfully: " + name);
            mainFrame.ShowPanel(new SupplierManagementPanel(mainFrame));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error saving supplier: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

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
import com.carmotors.suppliers.dao.SupplierEvaluationDAO;
import com.carmotors.suppliers.model.Supplier;
import com.carmotors.suppliers.model.SupplierEvaluation;
import com.carmotors.suppliers.view.PerformanceReportsPanel;
import com.carmotors.suppliers.view.PurchaseOrderFormPanel;
import com.carmotors.suppliers.view.SuppliedProductsPanel;
import com.carmotors.suppliers.view.SupplierEvaluationFormPanel;
import com.carmotors.suppliers.view.SupplierFormPanel;
import com.carmotors.suppliers.view.SupplierManagementPanel;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class SupplierController {

    private SupplierManagementPanel view;
    public CarMotorsWorkshop mainFrame;
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
        SupplierEvaluationFormPanel formPanel = new SupplierEvaluationFormPanel(this);
        mainFrame.ShowPanel(formPanel);
    }

    public void showSuppliedProducts() {
        SuppliedProductsPanel panel = new SuppliedProductsPanel(this);
        mainFrame.ShowPanel(panel);
    }

    public void showPurchaseOrderForm() {
        PurchaseOrderFormPanel formPanel = new PurchaseOrderFormPanel(this);
        mainFrame.ShowPanel(formPanel);
    }

    public void showPerformanceReports() {
        PerformanceReportsPanel panel = new PerformanceReportsPanel(this);
        mainFrame.ShowPanel(panel);
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

    public void saveSupplierEvaluation(int supplierId, LocalDate evaluationDate, int punctualityScore, int qualityScore, int costScore, double overallScore) {
        try {
            SupplierEvaluation evaluation = new SupplierEvaluation(supplierId, evaluationDate, punctualityScore, qualityScore, costScore, overallScore);
            SupplierEvaluationDAO.getInstance().add(evaluation);
            JOptionPane.showMessageDialog(view, "Evaluation saved successfully for Supplier ID: " + supplierId);
            mainFrame.ShowPanel(new SupplierManagementPanel(mainFrame));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Error saving evaluation: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void savePurchaseOrder(int supplierId, LocalDate now, String status, double totalCost) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

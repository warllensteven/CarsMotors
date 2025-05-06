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
import com.carmotors.suppliers.dao.SupplierProductDAO;
import com.carmotors.suppliers.model.SupplierProduct;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class SuppliedProductsPanel extends JPanel {
    private JTable productsTable;
    private JButton backButton;

    public SuppliedProductsPanel(SupplierController controller) {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        try {
            List<SupplierProduct> products = SupplierProductDAO.getInstance().getAll();
            String[] columnNames = {"ID", "Supplier ID", "Spare Part ID", "Supply Date", "Quantity", "Unit Price"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);

            for (SupplierProduct product : products) {
                model.addRow(new Object[]{
                    product.getId(),
                    product.getSupplierId(),
                    product.getSparePartId(),
                    product.getSupplyDate(),
                    product.getQuantity(),
                    product.getUnitPrice()
                });
            }

            productsTable = new JTable(model);
            add(new JScrollPane(productsTable), BorderLayout.CENTER);

            backButton = new JButton("Back");
            backButton.addActionListener(e -> controller.mainFrame.ShowPanel(new SupplierManagementPanel(controller.mainFrame)));
            add(backButton, BorderLayout.SOUTH);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error loading supplied products: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

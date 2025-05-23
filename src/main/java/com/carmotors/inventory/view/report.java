/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.carmotors.inventory.view;

import com.carmotors.inventory.dao.SparePartDAO;
import com.carmotors.inventory.model.SparePart;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author camper
 */
public class report extends javax.swing.JPanel {

    /**
     * Creates new form report
     */
    public report() {
        initComponents();
    }
    
    private void cargarTabla(List<SparePart> lista) {
    String[] columnas = {"ID", "Nombre", "Tipo", "Marca", "Modelo", "Proveedor", "Stock", "Stock Mínimo", "Ingreso", "Vencimiento", "Estado"};
        DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    for (SparePart sp : lista) {
        Object[] fila = {
            sp.getId(),
            sp.getName(),
            sp.getType(),
            sp.getBrand(),
            sp.getModel(),
            sp.getSupplierId(),
            sp.getStock(),
            sp.getMinStock(),
            sp.getEntryDate(),
            sp.getExpiryDate(),
            sp.getStatus()
        };
        modelo.addRow(fila);
    }

    TablaEmpleados.setModel(modelo);
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg = new javax.swing.JPanel();
        stockCritico = new javax.swing.JButton();
        sparePartExpiry = new javax.swing.JButton();
        reportGen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();

        bg.setBackground(new java.awt.Color(255, 255, 255));

        stockCritico.setText("Ver repuestos con stock critico");
        stockCritico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stockCriticoActionPerformed(evt);
            }
        });

        sparePartExpiry.setText("Ver repuestos proximos a vencer");
        sparePartExpiry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sparePartExpiryActionPerformed(evt);
            }
        });

        reportGen.setText("ver reporte general");
        reportGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportGenActionPerformed(evt);
            }
        });

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TablaEmpleados);

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(stockCritico, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addComponent(sparePartExpiry, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(reportGen, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addComponent(jScrollPane1)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stockCritico)
                    .addComponent(sparePartExpiry)
                    .addComponent(reportGen))
                .addGap(34, 34, 34)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(1031, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stockCriticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stockCriticoActionPerformed
             try {
        List<SparePart> criticos = SparePartDAO.getInstance().getStockCritico();
        cargarTabla(criticos);
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar repuestos con stock crítico.");
    }
    }//GEN-LAST:event_stockCriticoActionPerformed

    private void sparePartExpiryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sparePartExpiryActionPerformed
       try {
        int dias = 15; // Puedes personalizar este valor
        List<SparePart> proximos = SparePartDAO.getInstance().getProximosAVencer(dias);
        cargarTabla(proximos);
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar repuestos próximos a vencer.");
    }
    }//GEN-LAST:event_sparePartExpiryActionPerformed

    private void reportGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportGenActionPerformed
        try {
        List<SparePart> todos = SparePartDAO.getInstance().getAll();
        cargarTabla(todos);
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar el reporte general.");
    }
    }//GEN-LAST:event_reportGenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JPanel bg;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton reportGen;
    private javax.swing.JButton sparePartExpiry;
    private javax.swing.JButton stockCritico;
    // End of variables declaration//GEN-END:variables
}

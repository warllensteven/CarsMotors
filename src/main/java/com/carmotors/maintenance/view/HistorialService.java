/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.carmotors.maintenance.view;

import javax.swing.table.DefaultTableModel;
import com.carmotors.maintenance.dao.MaintenanceServiceDAO;
import com.carmotors.maintenance.model.MaintenanceService;
import java.util.List;


/**
 *
 * @author camper
 */
public class HistorialService extends javax.swing.JPanel {
private DefaultTableModel modeloTabla;
private final MaintenanceServiceDAO controller = MaintenanceServiceDAO.getInstance();

    /**
     * Creates new form report
     */
    public HistorialService() {
        initComponents();
        cargarServiciosPorEstado("Pendiente", "En proceso"); // Mostrar vigentes por defecto

    }
    
private void cargarServiciosPorEstado(String... estados) {
    String[] columnas = {
        "ID", "ID Cliente", "ID Vehículo", "Tipo", "Descripción", "Costo Labor",
        "Estado", "Fecha Inicio", "Fecha Fin", "ID Técnico"
    };
    modeloTabla = new DefaultTableModel(columnas, 0);

    try {
        List<MaintenanceService> lista = controller.getAll();
        for (MaintenanceService s : lista) {
            for (String estado : estados) {
                if (s.getStatus().equalsIgnoreCase(estado)) {
                    Object[] fila = {
                        s.getId(),
                        s.getIdClient(),
                        s.getVehicleId(),
                        s.getType(),
                        s.getDescription(),
                        s.getLaborCost(),
                        s.getStatus(),
                        s.getStartDate(),
                        s.getEndDate() != null ? s.getEndDate() : "—",
                        s.getTechnicianId()
                    };
                    modeloTabla.addRow(fila);
                    break;
                }
            }
        }
        TablaEmpleados.setModel(modeloTabla);
    } catch (Exception e) {
        e.printStackTrace();
        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar historial: " + e.getMessage());
    }
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
        Pendiente = new javax.swing.JButton();
        Completado = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();

        bg.setBackground(new java.awt.Color(255, 255, 255));

        Pendiente.setText("Pendiente");
        Pendiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PendienteActionPerformed(evt);
            }
        });

        Completado.setText("Completado");
        Completado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompletadoActionPerformed(evt);
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
                .addGap(132, 132, 132)
                .addComponent(Pendiente, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 209, Short.MAX_VALUE)
                .addComponent(Completado, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(172, 172, 172))
            .addComponent(jScrollPane1)
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pendiente)
                    .addComponent(Completado))
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

    private void PendienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PendienteActionPerformed
cargarServiciosPorEstado("Pendiente", "En proceso");  
    }//GEN-LAST:event_PendienteActionPerformed

    private void CompletadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompletadoActionPerformed
    cargarServiciosPorEstado("Completado", "Entregado");
    }//GEN-LAST:event_CompletadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Completado;
    private javax.swing.JButton Pendiente;
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JPanel bg;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}

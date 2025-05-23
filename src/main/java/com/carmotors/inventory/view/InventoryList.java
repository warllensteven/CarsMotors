/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.carmotors.inventory.view;

import javax.swing.table.DefaultTableModel;
import com.carmotors.inventory.controller.SparePartController;
import com.carmotors.inventory.model.SparePart;
import java.util.List;
import javax.swing.JTable;

/**
 *
 * @author camper
 */
public class InventoryList extends javax.swing.JPanel {

    DefaultTableModel modelo = new DefaultTableModel();
    private final SparePartController controller = new SparePartController();

    public InventoryList() {
        initComponents();
        
        
        cargarTabla();// <--- carga automática
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                filtrarTabla();
            }

            /**
             * Creates new form inventoryList
             */
        });
    }

    private void filtrarTabla() {
        String texto = txtBuscar.getText().trim().toLowerCase();
    if (texto.isEmpty()) {
        cargarTabla(); // si no hay texto, carga todo
        return;
    }

    List<SparePart> resultado = controller.buscarPorNombre(texto);
    String[] columnas = {"ID", "Nombre", "Tipo", "Marca", "Modelo", "Proveedor", "Stock", "Stock Mínimo", "Ingreso", "Vencimiento", "Estado"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);

    for (SparePart sp : resultado) {
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(656, 725));
        setLayout(new java.awt.BorderLayout());

        bg.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Liberation Sans", 1, 40)); // NOI18N
        jLabel1.setText("Inventario");

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

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel2.setText("BUSCAR");

        javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
        bg.setLayout(bgLayout);
        bgLayout.setHorizontalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgLayout.createSequentialGroup()
                        .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(bgLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 1151, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        bgLayout.setVerticalGroup(
            bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(120, Short.MAX_VALUE))
        );

        add(bg, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void cargarTabla() {
        try {
            List<SparePart> lista = controller.obtenerTodos();

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

        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar inventario: " + e.getMessage());
        }
             TablaEmpleados.getColumnModel().getColumn(0).setPreferredWidth(40);   // ID
        TablaEmpleados.getColumnModel().getColumn(1).setPreferredWidth(150);  // Nombre
        TablaEmpleados.getColumnModel().getColumn(2).setPreferredWidth(100);  // Tipo
        TablaEmpleados.getColumnModel().getColumn(3).setPreferredWidth(100);  // Marca
        TablaEmpleados.getColumnModel().getColumn(4).setPreferredWidth(100);  // Modelo
        TablaEmpleados.getColumnModel().getColumn(5).setPreferredWidth(100);  // Proveedor
        TablaEmpleados.getColumnModel().getColumn(6).setPreferredWidth(60);   // Stock
        TablaEmpleados.getColumnModel().getColumn(7).setPreferredWidth(100);  // Stock Mínimo
        TablaEmpleados.getColumnModel().getColumn(8).setPreferredWidth(120);  // Ingreso
        TablaEmpleados.getColumnModel().getColumn(9).setPreferredWidth(120);  // Vencimiento
        TablaEmpleados.getColumnModel().getColumn(10).setPreferredWidth(100); // Estado

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JPanel bg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtBuscar;
    // End of variables declaration//GEN-END:variables
}

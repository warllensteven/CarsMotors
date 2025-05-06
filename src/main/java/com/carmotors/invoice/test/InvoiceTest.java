/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.invoice.test;

/**
 *
 * @author warle
 */
import com.carmotors.client.dao.ClientDAO;
import com.carmotors.client.model.Client;
import com.carmotors.invoice.model.Invoice;
import com.carmotors.invoice.model.InvoiceDetail;
import com.carmotors.invoice.util.InvoiceGenerator;

public class InvoiceTest {
    public static void main(String[] args) {
        try {
            // Obtener un cliente
            Client client = ClientDAO.getInstance().getById(1); // Corregido
            if (client != null) {
                // Crear una factura
                Invoice invoice = new Invoice();
                invoice.setClientId(client.getId());
                invoice.addDetail(new InvoiceDetail("Cambio de aceite", 50.0));
                invoice.addDetail(new InvoiceDetail("Revisión de frenos", 30.0));

                // Generar el PDF
                String outputPath = "C:\\Users\\warle\\OneDrive\\Escritorio\\factura_electronica.pdf";
                InvoiceGenerator.generateInvoice(invoice, outputPath);
                System.out.println("Factura generada exitosamente en: " + outputPath);
            } else {
                System.out.println("Cliente no encontrado");
            }
        } catch (Exception e) {
            System.err.println("Error al generar factura: " + e.getMessage());
        }
    }
}
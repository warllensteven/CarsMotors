/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.einvoice;

/**
 *
 * @author warle
 */
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;

public class InvoiceGenerator {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static void generateInvoice(Invoice invoice, String filePath) {
        StringBuilder sb = new StringBuilder();
        sb.append("===== FACTURA ELECTRÓNICA =====\n");
        sb.append("Número de Factura: ").append(invoice.getInvoiceNumber()).append("\n");
        sb.append("Fecha: ").append(invoice.getDate()).append("\n");
        sb.append("Cliente: ").append(invoice.getClient().getName()).append("\n");
        sb.append("Identificación: ").append(invoice.getClient().getIdentification()).append("\n");
        sb.append("Email: ").append(invoice.getClient().getEmail()).append("\n");
        sb.append("------------------------------\n");
        sb.append("Ítems:\n");
        for (Item item : invoice.getItems()) {
            sb.append("- ").append(item.getDescription()).append(" | Cantidad: ").append(item.getQuantity())
              .append(" | Precio Unitario: $").append(df.format(item.getUnitPrice()))
              .append(" | Total: $").append(df.format(item.getTotalPrice())).append("\n");
        }
        sb.append("------------------------------\n");
        sb.append("Subtotal: $").append(df.format(invoice.calculateSubtotal())).append("\n");
        sb.append("Impuesto (").append(invoice.getTaxRate() * 100).append("%): $")
          .append(df.format(invoice.calculateTax())).append("\n");
        sb.append("Descuento: $").append(df.format(invoice.getDiscount())).append("\n");
        sb.append("Total: $").append(df.format(invoice.calculateTotal())).append("\n");
        sb.append("===== GRACIAS POR SU COMPRA =====");

        // Guardar en archivo
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(sb.toString());
            System.out.println("Factura generada exitosamente en: " + filePath);
        } catch (IOException e) {
            System.err.println("Error al generar la factura: " + e.getMessage());
        }
    }
}

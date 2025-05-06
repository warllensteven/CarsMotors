/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.invoice.dao;

/**
 *
 * @author warle
 */
import com.carmotors.client.dao.ClientDAO;
import com.carmotors.client.model.Client;
import com.carmotors.invoice.model.Invoice;
import com.carmotors.invoice.model.InvoiceDetail;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Image;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;

public class InvoiceGenerator {
    private static final DecimalFormat df = new DecimalFormat("#.##");

    public static void generateInvoice(Invoice invoice, String filePath) {
        try {
            // Obtener cliente desde clientId (simulado por ahora)
            ClientDAO clientDAO = ClientDAO.getInstance();
            Client client = clientDAO.getById(invoice.getClientId());

            // Crear el documento PDF
            PdfWriter writer = new PdfWriter(new FileOutputStream(filePath));
            PdfDocument pdf = new PdfDocument(writer);
            Document document = new Document(pdf);

            // Agregar contenido al PDF
            document.add(new Paragraph("===== FACTURA ELECTRÓNICA ====="));
            document.add(new Paragraph("Número de Factura: " + invoice.getId()));
            document.add(new Paragraph("Fecha: " + invoice.getIssueDate()));
            document.add(new Paragraph("Cliente: " + (client != null ? client.getName() : "Cliente no encontrado")));
            document.add(new Paragraph("Identificación: " + (client != null ? client.getIdentification() : "")));
            document.add(new Paragraph("Email: " + (client != null ? client.getEmail() : "")));
            document.add(new Paragraph("------------------------------"));
            document.add(new Paragraph("Ítems:"));
            for (InvoiceDetail item : invoice.getItems()) {
                document.add(new Paragraph("- " + item.getDescription() + " | Cantidad: " + item.getQuantity()
                        + " | Precio Unitario: $" + df.format(item.getUnitPrice())
                        + " | Subtotal: $" + df.format(item.getSubtotal())));
            }
            document.add(new Paragraph("------------------------------"));
            document.add(new Paragraph("Subtotal: $" + df.format(invoice.calculateSubtotal())));
            document.add(new Paragraph("Impuesto (19%): $" + df.format(invoice.calculateTax(0.19))));
            document.add(new Paragraph("Descuento: $" + (invoice.getDiscountStrategy() != null ? df.format(invoice.getDiscountStrategy().applyDiscount(invoice.getTotal())) : "0.00")));
            document.add(new Paragraph("Total: $" + df.format(invoice.getTotal())));
            document.add(new Paragraph("===== GRACIAS POR SU COMPRA ====="));

            // Generar código QR
            String qrData = "Factura: " + invoice.getId() + " | Total: $" + df.format(invoice.getTotal());
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrData, BarcodeFormat.QR_CODE, 100, 100);
            ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
            Image qrCodeImage = new Image(com.itextpdf.io.image.ImageDataFactory.create(pngOutputStream.toByteArray()));
            document.add(qrCodeImage);

            // Cerrar el documento
            document.close();
            System.out.println("Factura generada exitosamente en: " + filePath);

        } catch (IOException | WriterException  e) {
            System.err.println("Error al generar la factura: " + e.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}


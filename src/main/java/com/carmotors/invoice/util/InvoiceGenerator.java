/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.invoice.util;

/**
 *
 * @author warle
 */
import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
import com.itextpdf.layout.properties.UnitValue;
import com.carmotors.invoice.model.Invoice;
import com.carmotors.invoice.model.InvoiceDetail;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class InvoiceGenerator {
    public static void generateInvoice(Invoice invoice, String outputPath) throws Exception {
        
        PdfWriter writer = new PdfWriter(outputPath);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Paragraph header = new Paragraph("Car Motors Workshop - Factura Electrónica")
            .setFontSize(20)
            .setFontColor(ColorConstants.DARK_GRAY)
            .setTextAlignment(TextAlignment.CENTER)
            .setBold();
        document.add(header);

        document.add(new Paragraph("\nInformación de la Factura:")
            .setFontSize(14)
            .setBold());
        document.add(new Paragraph("ID Cliente: " + invoice.getClientId())
            .setFontSize(12));
        document.add(new Paragraph("Nombre del Cliente: " + (invoice.getClientName() != null ? invoice.getClientName() : "No especificado"))
            .setFontSize(12));
        document.add(new Paragraph("Fecha de Emisión: " + invoice.getIssueDate())
            .setFontSize(12));
        document.add(new Paragraph("Total: $" + String.format("%.2f", invoice.getTotal()))
            .setFontSize(12));

        float[] columnWidths = {2, 3, 2, 2};
        Table table = new Table(UnitValue.createPercentArray(columnWidths));
        table.setWidth(UnitValue.createPercentValue(100))
             .setFontSize(10)
             .setBackgroundColor(ColorConstants.LIGHT_GRAY);

        table.addCell(new Cell().add(new Paragraph("Cantidad").setBold())
            .setBackgroundColor(ColorConstants.GRAY)
            .setFontColor(ColorConstants.WHITE));
        table.addCell(new Cell().add(new Paragraph("Descripción").setBold())
            .setBackgroundColor(ColorConstants.GRAY)
            .setFontColor(ColorConstants.WHITE));
        table.addCell(new Cell().add(new Paragraph("Precio Unitario").setBold())
            .setBackgroundColor(ColorConstants.GRAY)
            .setFontColor(ColorConstants.WHITE));
        table.addCell(new Cell().add(new Paragraph("Subtotal").setBold())
            .setBackgroundColor(ColorConstants.GRAY)
            .setFontColor(ColorConstants.WHITE));

        for (InvoiceDetail detail : invoice.getDetails()) {
            table.addCell(new Cell().add(new Paragraph(String.valueOf(detail.getQuantity()))));
            table.addCell(new Cell().add(new Paragraph(detail.getDescription())));
            table.addCell(new Cell().add(new Paragraph("$" + String.format("%.2f", detail.getPrice()))));
            table.addCell(new Cell().add(new Paragraph("$" + String.format("%.2f", detail.getSubtotal()))));
        }

        document.add(table);

        String qrData = "ID Factura: " + invoice.getId() + "\n" +
                       "Cliente: " + invoice.getClientId() + " - " + invoice.getClientName() + "\n" +
                       "Total: $" + String.format("%.2f", invoice.getTotal()) + "\n" +
                       "CUFE: " + (invoice.getCufe() != null ? invoice.getCufe() : "No disponible");
        String qrImagePath = outputPath.replace(".pdf", "_qrcode.png");
        generateQRCode(qrData, qrImagePath, 200, 200);

        Image qrCodeImage = new Image(com.itextpdf.io.image.ImageDataFactory.create(qrImagePath))
            .setWidth(100)
            .setHeight(100);
        document.add(new Paragraph("\nCódigo QR de Validación:")
            .setFontSize(12)
            .setBold());
        document.add(qrCodeImage);

        document.close();
        Files.deleteIfExists(Path.of(qrImagePath));
    }

    private static void generateQRCode(String data, String path, int width, int height) throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(data, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
        byte[] pngData = pngOutputStream.toByteArray();
        Files.write(Path.of(path), pngData);
    }
}
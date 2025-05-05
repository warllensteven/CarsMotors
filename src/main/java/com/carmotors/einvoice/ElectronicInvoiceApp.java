/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.einvoice;

/**
 *
 * @author warle
 */
public class ElectronicInvoiceApp {
    public static void main(String[] args) {
        // Crear cliente
        Client client = new Client("Juan Pérez", "1234567890", "juan@email.com");

        // Crear factura
        Invoice invoice = new Invoice("FAC-001", client, 0.19, 10.0); // IVA 19%, descuento $10

        // Agregar ítems
        invoice.addItem(new Item("Cambio de Aceite", 1, 50.0));
        invoice.addItem(new Item("Filtro de Aceite", 1, 20.0));
        invoice.addItem(new Item("Mano de Obra", 2, 30.0));

        // Generar factura
        InvoiceGenerator.generateInvoice(invoice, "factura_electronica.txt");
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.test;

/**
 *
 * @author warle
 */
import com.carmotors.client.dao.ClientDAO;
import com.carmotors.client.model.Client;
import com.carmotors.database.DatabaseConnection;
import com.carmotors.invoice.dao.InvoiceDAO;
import com.carmotors.invoice.model.Invoice;
import com.carmotors.invoice.model.InvoiceDetail;
import com.carmotors.invoice.util.InvoiceGenerator;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class DAOTest {
    public static void main(String[] args) {
        try {
            // Prueba de conexión a la base de datos
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            System.out.println("Conexión a la base de datos establecida con éxito.");

            // Crear un cliente
            ClientDAO clientDAO = ClientDAO.getInstance();
            Client client = new Client(1, "Carlos Pérez", "1234567890", "123456789", "carlos@email.com");
            // Guardar el cliente (si no existe, asegúrate de que ClientDAO tenga un método save)
            // Nota: Si ClientDAO no tiene save, descomenta y ajusta según tu implementación
            // clientDAO.save(client);

            // Verificar si el cliente existe
            Client retrievedClient = clientDAO.getById(1);
            if (retrievedClient != null) {
                System.out.println("Cliente encontrado: " + retrievedClient.getName());
            } else {
                System.out.println("Cliente no encontrado, creándolo...");
                // Aquí deberías implementar el guardado si no existe
            }

            // Crear una factura
            InvoiceDAO invoiceDAO = InvoiceDAO.getInstance();
            Invoice invoice = new Invoice();
            invoice.setId(1);
            invoice.setClientId(retrievedClient != null ? retrievedClient.getId() : 1);
            invoice.setClientName(retrievedClient != null ? retrievedClient.getName() : "Carlos Pérez");
            invoice.setIssueDate(LocalDateTime.now());
            invoice.setTotal(80.0);
            invoice.setCufe("CUFE123456789");
            invoice.setStatus("Pendiente"); // Establecer un valor predeterminado para status
            invoice.addDetail(new InvoiceDetail("Cambio de aceite", 50.0));
            invoice.addDetail(new InvoiceDetail("Revisión de frenos", 30.0));

            // Guardar la factura
            invoiceDAO.save(invoice);
            System.out.println("Factura guardada con éxito.");

            // Generar el PDF de la factura
            String outputPath = "C:\\Users\\warle\\OneDrive\\Escritorio\\factura_electronica.pdf";
            InvoiceGenerator.generateInvoice(invoice, outputPath);
            System.out.println("Factura generada en PDF: " + outputPath);

            // Consultar la factura por ID
            Invoice retrievedInvoice = invoiceDAO.getById(1);
            if (retrievedInvoice != null) {
                System.out.println("Factura encontrada - ID: " + retrievedInvoice.getId() +
                                   ", Cliente: " + retrievedInvoice.getClientName() +
                                   ", Total: $" + retrievedInvoice.getTotal() +
                                   ", Status: " + retrievedInvoice.getStatus());
            } else {
                System.out.println("Factura no encontrada.");
            }

            // Listar todas las facturas
            System.out.println("Listado de todas las facturas:");
            invoiceDAO.getAll().forEach(inv -> System.out.println("ID: " + inv.getId() +
                                                                 ", Cliente: " + inv.getClientName() +
                                                                 ", Total: $" + inv.getTotal() +
                                                                 ", Status: " + inv.getStatus()));

        } catch (SQLException e) {
            System.err.println("Error al ejecutar la prueba: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error al generar la factura en PDF: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Cerrar la conexión (opcional, dependiendo de tu diseño)
            DatabaseConnection.getInstance().closeConnection();
        }
    }
}
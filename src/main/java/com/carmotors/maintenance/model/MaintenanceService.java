package com.carmotors.maintenance.model;

import com.carmotors.client.dao.ClientDAO;
import com.carmotors.client.model.Client;
import com.carmotors.invoice.model.Invoice;
import com.carmotors.invoice.model.InvoiceDetail;
import com.carmotors.invoice.util.InvoiceGenerator;
import com.carmotors.invoice.dao.InvoiceDAO;

import java.time.LocalDateTime;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MaintenanceService {
    private int id;
    private int idClient;
    private int vehicleId;
    private String type;
    private String description;
    private double laborCost;
    private String status;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int technicianId;

    // Constructor con ID
    public MaintenanceService(int id, int idClient, int vehicleId, String type, String description, double laborCost,
            String status, LocalDateTime startDate, LocalDateTime endDate, int technicianId) {
        this.id = id;
        this.idClient = idClient;
        this.vehicleId = vehicleId;
        this.type = type;
        this.description = description;
        this.laborCost = laborCost;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.technicianId = technicianId;
    }

    // Constructor sin ID
    public MaintenanceService(int idClient, int vehicleId, String type, String description, double laborCost,
            String status, LocalDateTime startDate, LocalDateTime endDate, int technicianId) {
        this.idClient = idClient;
        this.vehicleId = vehicleId;
        this.type = type;
        this.description = description;
        this.laborCost = laborCost;
        this.status = status;
        this.startDate = startDate;
        this.endDate = endDate;
        this.technicianId = technicianId;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getLaborCost() {
        return laborCost;
    }

    public void setLaborCost(double laborCost) {
        this.laborCost = laborCost;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public int getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(int technicianId) {
        this.technicianId = technicianId;
    }

    /**
     * Genera una factura basada en el servicio de mantenimiento y la guarda como PDF.
     * @param invoiceId El ID de la factura a generar.
     * @param outputPath La ruta donde se guardará el PDF de la factura.
     * @throws Exception Si hay un error al generar la factura o el PDF.
     */
    public void generateInvoice(int invoiceId, String outputPath) throws Exception {
        // Asegurarse de que la carpeta facturas exista
        Path outputDir = Paths.get(outputPath).getParent();
        if (outputDir != null && !Files.exists(outputDir)) {
            Files.createDirectories(outputDir);
        }

        // Obtener el nombre del cliente desde ClientDAO
        Client client = ClientDAO.getInstance().getById(this.idClient);
        String clientName = (client != null) ? client.getName() : "Cliente Desconocido";

        // Crear una nueva factura
        Invoice invoice = new Invoice();
        invoice.setId(invoiceId);
        invoice.setClientId(this.idClient);
        invoice.setClientName(clientName);
        invoice.setIssueDate(LocalDateTime.now());
        invoice.setTotal(this.laborCost);
        invoice.setCufe("CUFE" + invoiceId + "-" + System.currentTimeMillis());
        invoice.setStatus("Pendiente");

        // Añadir el detalle de la factura basado en el servicio
        InvoiceDetail detail = new InvoiceDetail(this.description, this.laborCost);
        detail.setQuantity(1);
        invoice.addDetail(detail);

        // Guardar la factura en la base de datos
        InvoiceDAO invoiceDAO = InvoiceDAO.getInstance();
        invoiceDAO.save(invoice);

        // Generar el PDF
        InvoiceGenerator.generateInvoice(invoice, outputPath);
    }
}
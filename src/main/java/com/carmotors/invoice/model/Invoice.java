package com.carmotors.invoice.model;

import java.time.LocalDateTime;

public class Invoice {

    private int id;
    private int clientId;
    private int maintenanceServiceId;
    private LocalDateTime issueDate;
    private double total;
    private String cufe;
    private String qrCode;
    private String status;
    private DiscountStrategy discountStrategy;  // Añadido para el descuento

    public Invoice(int id, int clientId, int maintenanceServiceId, LocalDateTime issueDate, double total,
                   String cufe, String qrCode, String status, DiscountStrategy discountStrategy) {
        this.id = id;
        this.clientId = clientId;
        this.maintenanceServiceId = maintenanceServiceId;
        this.issueDate = issueDate;
        this.total = total;
        this.cufe = cufe;
        this.qrCode = qrCode;
        this.status = status;
        this.discountStrategy = discountStrategy;  // Recibe el descuento al crear la factura
    }

    public Invoice(int clientId, int maintenanceServiceId, LocalDateTime issueDate, double total, 
                   String cufe, String qrCode, String status, DiscountStrategy discountStrategy) {
        this.clientId = clientId;
        this.maintenanceServiceId = maintenanceServiceId;
        this.issueDate = issueDate;
        this.total = total;
        this.cufe = cufe;
        this.qrCode = qrCode;
        this.status = status;
        this.discountStrategy = discountStrategy;  // Recibe el descuento al crear la factura
    }
    
    

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getMaintenanceServiceId() {
        return maintenanceServiceId;
    }

    public void setMaintenanceServiceId(int maintenanceServiceId) {
        this.maintenanceServiceId = maintenanceServiceId;
    }

    public LocalDateTime getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCufe() {
        return cufe;
    }

    public void setCufe(String cufe) {
        this.cufe = cufe;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    // Método para aplicar el descuento
    public void applyDiscount() {
        if (discountStrategy != null) {
            this.total = discountStrategy.applyDiscount(this.total);
        }
    }
}

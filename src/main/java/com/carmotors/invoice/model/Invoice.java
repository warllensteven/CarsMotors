package com.carmotors.invoice.model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

public class Invoice {

    private int id;
    private int clientId;
    private String clientName;
    private int maintenanceServiceId;
    private LocalDateTime issueDate;
    private double total;
    private String cufe;
    private String qrCode;
    private String status;
    private List<InvoiceDetail> details = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public Invoice() {
    }

    public Invoice(int id, int clientId, LocalDateTime issueDate, double total,
            String cufe, String qrCode, String status, DiscountStrategy discountStrategy) {
        this.id = id;
        this.clientId = clientId;
        this.issueDate = issueDate;
        this.total = total;
        this.cufe = cufe;
        this.qrCode = qrCode;
        this.status = status;
        this.discountStrategy = discountStrategy;
    }

    public Invoice(int id, int clientId, String clientName, LocalDateTime issueDate, double total,
            String cufe, String qrCode, String status, DiscountStrategy discountStrategy) {
        this.id = id;
        this.clientId = clientId;
        this.clientName = clientName;
        this.issueDate = issueDate;
        this.total = total;
        this.cufe = cufe;
        this.qrCode = qrCode;
        this.status = status;
        this.discountStrategy = discountStrategy;
    }

    public Invoice(int id, int clientId, int maintenanceServiceId, String clientName, LocalDateTime issueDate, double total,
            String cufe, String qrCode, String status, DiscountStrategy discountStrategy) {
        this.id = id;
        this.clientId = clientId;
        this.maintenanceServiceId = maintenanceServiceId;
        this.clientName = clientName;
        this.issueDate = issueDate;
        this.total = total;
        this.cufe = cufe;
        this.qrCode = qrCode;
        this.status = status;
        this.discountStrategy = discountStrategy;
    }

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

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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

    public List<InvoiceDetail> getDetails() {
        return details;
    }

    public List<InvoiceDetail> getItems() {
        return details;
    }

    public void addDetail(InvoiceDetail detail) {
        details.add(detail);
    }

    public DiscountStrategy getDiscountStrategy() {
        return discountStrategy;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public void applyDiscount() {
        if (discountStrategy != null) {
            this.total = discountStrategy.applyDiscount(this.total);
        }
    }

    public double calculateSubtotal() {
        return details.stream().mapToDouble(InvoiceDetail::getSubtotal).sum();
    }

    public double calculateTax(double subtotal) {
        return subtotal * 0.19;
    }
}

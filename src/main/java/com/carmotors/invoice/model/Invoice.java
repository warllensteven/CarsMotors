/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.invoice.model;

/**
 *
 * @author warle
 */
import java.time.LocalDate;

public class Invoice {
    private int id;
    private int clientId;
    private int maintenanceServiceId;
    private LocalDate issueDate;
    private double total;
    private String cufe;
    private String qrCode;
    private String status;

    public Invoice(int id, int clientId, int maintenanceServiceId, LocalDate issueDate, double total,
                   String cufe, String qrCode, String status) {
        this.id = id;
        this.clientId = clientId;
        this.maintenanceServiceId = maintenanceServiceId;
        this.issueDate = issueDate;
        this.total = total;
        this.cufe = cufe;
        this.qrCode = qrCode;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getClientId() { return clientId; }
    public void setClientId(int clientId) { this.clientId = clientId; }
    public int getMaintenanceServiceId() { return maintenanceServiceId; }
    public void setMaintenanceServiceId(int maintenanceServiceId) { this.maintenanceServiceId = maintenanceServiceId; }
    public LocalDate getIssueDate() { return issueDate; }
    public void setIssueDate(LocalDate issueDate) { this.issueDate = issueDate; }
    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
    public String getCufe() { return cufe; }
    public void setCufe(String cufe) { this.cufe = cufe; }
    public String getQrCode() { return qrCode; }
    public void setQrCode(String qrCode) { this.qrCode = qrCode; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}

package com.carmotors.core.builder;

import com.carmotors.invoice.model.Invoice;
import com.carmotors.invoice.model.DiscountStrategy;
import java.time.LocalDateTime;

public class InvoiceBuilder {
    private int clientId;
    private int maintenanceServiceId;
    private LocalDateTime issueDate;
    private double total;
    private String cufe;
    private String qrCode;
    private String status;
    private DiscountStrategy discountStrategy;

    public InvoiceBuilder setClientId(int clientId) {
        this.clientId = clientId;
        return this;
    }

    public InvoiceBuilder setMaintenanceServiceId(int maintenanceServiceId) {
        this.maintenanceServiceId = maintenanceServiceId;
        return this;
    }

    public InvoiceBuilder setIssueDate(LocalDateTime issueDate) {
        this.issueDate = issueDate;
        return this;
    }

    public InvoiceBuilder setTotal(double total) {
        this.total = total;
        return this;
    }

    public InvoiceBuilder setCufe(String cufe) {
        this.cufe = cufe;
        return this;
    }

    public InvoiceBuilder setQrCode(String qrCode) {
        this.qrCode = qrCode;
        return this;
    }

    public InvoiceBuilder setStatus(String status) {
        this.status = status;
        return this;
    }

    public InvoiceBuilder setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        return this;
    }

    public Invoice build() {
        return new Invoice(clientId, maintenanceServiceId, issueDate, total, cufe, qrCode, status, discountStrategy);
    }
}

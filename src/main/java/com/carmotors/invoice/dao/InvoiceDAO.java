package com.carmotors.invoice.dao;

import com.carmotors.client.dao.ClientDAO;
import com.carmotors.client.model.Client;
import com.carmotors.database.DatabaseConnection;
import com.carmotors.invoice.model.DiscountStrategy;
import com.carmotors.invoice.model.Invoice;
import com.carmotors.invoice.model.InvoiceDetail;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDAO {
    private static InvoiceDAO instance;

    private InvoiceDAO() {
    }

    public static synchronized InvoiceDAO getInstance() {
        if (instance == null) {
            instance = new InvoiceDAO();
        }
        return instance;
    }

    public Invoice getById(int id) throws SQLException {
        String query = "SELECT * FROM invoices WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int clientId = rs.getInt("client_id");
                Client client = ClientDAO.getInstance().getById(clientId);
                String clientName = (client != null) ? client.getName() : "Desconocido";

                return new Invoice(
                    rs.getInt("id"),
                    clientId,
                    clientName,
                    rs.getTimestamp("issue_date").toLocalDateTime(),
                    rs.getDouble("total"),
                    rs.getString("cufe"),
                    rs.getString("qr_code"),
                    rs.getString("status"),
                    null
                );
            }
        }
        return null;
    }

    public List<Invoice> getAll() throws SQLException {
        List<Invoice> invoices = new ArrayList<>();
        String query = "SELECT * FROM invoices";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int clientId = rs.getInt("client_id");
                Client client = ClientDAO.getInstance().getById(clientId);
                String clientName = (client != null) ? client.getName() : "Desconocido";

                invoices.add(new Invoice(
                    rs.getInt("id"),
                    clientId,
                    clientName,
                    rs.getTimestamp("issue_date").toLocalDateTime(),
                    rs.getDouble("total"),
                    rs.getString("cufe"),
                    rs.getString("qr_code"),
                    rs.getString("status"),
                    null
                ));
            }
        }
        return invoices;
    }

    public void save(Invoice invoice) throws SQLException {
        String query = "INSERT INTO invoices (id, client_id, issue_date, total, cufe, qr_code, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, invoice.getId());
            stmt.setInt(2, invoice.getClientId());
            stmt.setTimestamp(3, Timestamp.valueOf(invoice.getIssueDate()));
            stmt.setDouble(4, invoice.getTotal());
            stmt.setString(5, invoice.getCufe());
            stmt.setString(6, invoice.getQrCode());
            stmt.setString(7, invoice.getStatus());
            stmt.executeUpdate();
        }
    }
}

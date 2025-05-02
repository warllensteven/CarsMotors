/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.provider.dao;

/**
 *
 * @author warle
 */
import com.carmotors.database.DatabaseConnection;
import com.carmotors.provider.model.SupplierEvaluation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SupplierEvaluationDAO {
    private static SupplierEvaluationDAO instance;

    private SupplierEvaluationDAO() {
        // Constructor privado para Singleton
    }

    public static SupplierEvaluationDAO getInstance() {
        if (instance == null) {
            instance = new SupplierEvaluationDAO();
        }
        return instance;
    }

    public void add(SupplierEvaluation evaluation) throws SQLException {
        String query = "INSERT INTO supplier_evaluations (supplier_id, evaluation_date, punctuality_score, quality_score, cost_score, overall_score) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, evaluation.getSupplierId());
            stmt.setObject(2, evaluation.getEvaluationDate());
            stmt.setInt(3, evaluation.getPunctualityScore());
            stmt.setInt(4, evaluation.getQualityScore());
            stmt.setInt(5, evaluation.getCostScore());
            stmt.setInt(6, evaluation.getOverallScore());
            stmt.executeUpdate();
        }
    }

    public SupplierEvaluation getById(int id) throws SQLException {
        String query = "SELECT * FROM supplier_evaluations WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new SupplierEvaluation(
                        rs.getInt("id"),
                        rs.getInt("supplier_id"),
                        rs.getObject("evaluation_date", LocalDate.class),
                        rs.getInt("punctuality_score"),
                        rs.getInt("quality_score"),
                        rs.getInt("cost_score"),
                        rs.getInt("overall_score")
                    );
                }
            }
        }
        return null;
    }

    public List<SupplierEvaluation> getAll() throws SQLException {
        List<SupplierEvaluation> evaluations = new ArrayList<>();
        String query = "SELECT * FROM supplier_evaluations";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                SupplierEvaluation evaluation = new SupplierEvaluation(
                    rs.getInt("id"),
                    rs.getInt("supplier_id"),
                    rs.getObject("evaluation_date", LocalDate.class),
                    rs.getInt("punctuality_score"),
                    rs.getInt("quality_score"),
                    rs.getInt("cost_score"),
                    rs.getInt("overall_score")
                );
                evaluations.add(evaluation);
            }
        }
        return evaluations;
    }

    public void update(SupplierEvaluation evaluation) throws SQLException {
        String query = "UPDATE supplier_evaluations SET supplier_id = ?, evaluation_date = ?, punctuality_score = ?, quality_score = ?, cost_score = ?, overall_score = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, evaluation.getSupplierId());
            stmt.setObject(2, evaluation.getEvaluationDate());
            stmt.setInt(3, evaluation.getPunctualityScore());
            stmt.setInt(4, evaluation.getQualityScore());
            stmt.setInt(5, evaluation.getCostScore());
            stmt.setInt(6, evaluation.getOverallScore());
            stmt.setInt(7, evaluation.getId());
            stmt.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String query = "DELETE FROM supplier_evaluations WHERE id = ?";
        try (Connection conn = DatabaseConnection.getInstance().getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

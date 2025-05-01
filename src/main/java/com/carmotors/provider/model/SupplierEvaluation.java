/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.provider.model;

/**
 *
 * @author warle
 */
import java.time.LocalDate;

public class SupplierEvaluation {

    private int id;
    private int supplierId;
    private LocalDate evaluationDate;
    private int punctualityScore;
    private int qualityScore;
    private int costScore;
    private int overallScore;

    public SupplierEvaluation(int id, int supplierId, LocalDate evaluationDate, int punctualityScore,
            int qualityScore, int costScore, int overallScore) {
        this.id = id;
        this.supplierId = supplierId;
        this.evaluationDate = evaluationDate;
        this.punctualityScore = punctualityScore;
        this.qualityScore = qualityScore;
        this.costScore = costScore;
        this.overallScore = overallScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }

    public LocalDate getEvaluationDate() {
        return evaluationDate;
    }

    public void setEvaluationDate(LocalDate evaluationDate) {
        this.evaluationDate = evaluationDate;
    }

    public int getPunctualityScore() {
        return punctualityScore;
    }

    public void setPunctualityScore(int punctualityScore) {
        this.punctualityScore = punctualityScore;
    }

    public int getQualityScore() {
        return qualityScore;
    }

    public void setQualityScore(int qualityScore) {
        this.qualityScore = qualityScore;
    }

    public int getCostScore() {
        return costScore;
    }

    public void setCostScore(int costScore) {
        this.costScore = costScore;
    }

    public int getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(int overallScore) {
        this.overallScore = overallScore;
    }
}

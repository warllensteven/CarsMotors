/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.stats.model;

/**
 *
 * @author camper
 */
public class TechnicianPerformance {
    private String technicianName;
    private int jobsCompleted;
    private double totalHours;

    public TechnicianPerformance(String technicianName, int jobsCompleted, double totalHours) {
        this.technicianName = technicianName;
        this.jobsCompleted = jobsCompleted;
        this.totalHours = totalHours;
    }

    public String getTechnicianName() {
        return technicianName;
    }

    public int getJobsCompleted() {
        return jobsCompleted;
    }

    public double getTotalHours() {
        return totalHours;
    }
    
    
}

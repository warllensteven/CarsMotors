/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.stats.model;


/**
 *
 * @author camper
 */
public class ServiceReport {
    private String serviceType;
    private int count;

    public ServiceReport(String serviceType, int count) {
        this.serviceType = serviceType;
        this.count = count;
    }

    public String getServiceType() {
        return serviceType;
    }

    public int getCount() {
        return count;
    }
}


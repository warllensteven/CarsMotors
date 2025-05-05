/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.einvoice;

/**
 *
 * @author warle
 */
public class Client {
    private String name;
    private String identification;
    private String email;

    public Client(String name, String identification, String email) {
        this.name = name;
        this.identification = identification;
        this.email = email;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getIdentification() {
        return identification;
    }

    public String getEmail() {
        return email;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.builder;

import com.carmotors.client.model.Client;

/**
 *
 * @author camper
 */
public class ClientBuilder {
    private String name;
    private String email;
    private String phone;

    public ClientBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public ClientBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public ClientBuilder setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public Client build() {
        return new Client(name, email, phone);
    }
}

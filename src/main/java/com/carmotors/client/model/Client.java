/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.client.model;

/**
 *
 * @author warle
 */
public class Client {
    private int id;
    private String name;
    private String identification;
    private String phone;
    private String email;

    public Client(int id, String name, String identification, String phone, String email) {
        this.id = id;
        this.name = name;
        this.identification = identification;
        this.phone = phone;
        this.email = email;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIdentification() { return identification; }
    public void setIdentification(String identification) { this.identification = identification; }
    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

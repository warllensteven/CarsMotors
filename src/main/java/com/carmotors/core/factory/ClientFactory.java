/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.factory;

import com.carmotors.client.model.Client;

/**
 *
 * @author camper
 */
public class ClientFactory {
       public static Client createClient(String name, String identification, String phone, String email) {
        return new Client(name, identification, phone, email);
    }
}

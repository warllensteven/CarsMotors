/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.core.factory;

import com.carmotors.suppliers.model.Supplier;

/**
 *
 * @author camper
 */
public class SupplierFactory {
     public static Supplier createSupplier(String name, String nit, String contact, String visitFrequency) {
        return new Supplier(name, nit, contact, visitFrequency);
    }
}

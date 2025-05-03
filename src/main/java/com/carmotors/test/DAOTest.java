/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.carmotors.test;

/**
 *
 * @author warle
 */
import com.carmotors.client.dao.ClientDAO;
import com.carmotors.client.model.Client;
import com.carmotors.inventory.dao.SparePartDAO;
import com.carmotors.inventory.model.SparePart;
import com.carmotors.provider.dao.SupplierDAO;
import com.carmotors.provider.model.Supplier;
import com.carmotors.client.dao.VehicleDAO;
import com.carmotors.client.model.Vehicle;
import com.carmotors.database.DatabaseConnection;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class DAOTest {
    /*public static void main(String[] args) {
        try {
            testSparePartDAO();
            testSupplierDAO();
            testVehicleDAO();
            System.out.println("Todas las pruebas completadas exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error durante las pruebas: " + e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    private static void testSparePartDAO() throws SQLException {
        SupplierDAO supplierDAO = SupplierDAO.getInstance();
        SparePartDAO sparePartDAO = SparePartDAO.getInstance();
        
        // Crear (Insertar) un proveedor primero
        Supplier supplier = new Supplier(0, "Proveedor Bosch", "123456789", "contact@bosch.com", "Semanal");
        supplierDAO.add(supplier);
        System.out.println("Supplier agregado con ID: " + supplier.getId());

        // Crear (Insertar) un r public static void main(String[] args) {
        try {
            testSparePartDAO();
            testSupplierDAO();
            testVehicleDAO();
            System.out.println("Todas las pruebas completadas exitosamente.");
        } catch (SQLException e) {
            System.err.println("Error durante las pruebas: " + e.getMessage());
        } finally {
            DatabaseConnection.getInstance().closeConnection();
        }
    }

    private static void testSparePartDAO() throws SQLException {
        SupplierDAO supplierDAO = SupplierDAO.getInstance();
        SparePartDAO sparePartDAO = SparePartDAO.getInstance();
        
        // Crear (Iepuesto con el supplier_id del proveedor recién creado
        SparePart sparePart = new SparePart(0, "Frenos Delanteros", "Mecánico", "Bosch", "X123", supplier.getId(), 10, 5, LocalDate.now(), LocalDate.now().plusYears(1), "Disponible");
        sparePartDAO.add(sparePart);
        System.out.println("SparePart agregado con ID: " + sparePart.getId());

        // Leer (Consultar por ID)
        SparePart retrievedSparePart = sparePartDAO.getById(sparePart.getId());
        System.out.println("SparePart recuperado: " + retrievedSparePart.getName());

        // Actualizar
        retrievedSparePart.setStock(15);
        sparePartDAO.update(retrievedSparePart);
        System.out.println("SparePart actualizado, nuevo stock: " + sparePartDAO.getById(sparePart.getId()).getStock());

        // Consultar todos
        List<SparePart> spareParts = sparePartDAO.getAll();
        System.out.println("Total SpareParts: " + spareParts.size());

        // Eliminar el repuesto y el proveedor
        sparePartDAO.delete(sparePart.getId());
        supplierDAO.delete(supplier.getId());
        System.out.println("SparePart y Supplier eliminados. Nuevo total SpareParts: " + sparePartDAO.getAll().size());
    }

    private static void testSupplierDAO() throws SQLException {
        SupplierDAO supplierDAO = SupplierDAO.getInstance();

        // Crear (Insertar)
        Supplier supplier = new Supplier(0, "Proveedor Toyota", "987654321", "contact@toyota.com", "Mensual");
        supplierDAO.add(supplier);
        System.out.println("Supplier agregado con ID: " + supplier.getId());

        // Leer (Consultar por ID)
        Supplier retrievedSupplier = supplierDAO.getById(supplier.getId());
        System.out.println("Supplier recuperado: " + retrievedSupplier.getName());

        // Actualizar
        retrievedSupplier.setContact("newcontact@toyota.com");
        supplierDAO.update(retrievedSupplier);
        System.out.println("Supplier actualizado, nuevo contacto: " + supplierDAO.getById(supplier.getId()).getContact());

        // Consultar todos
        List<Supplier> suppliers = supplierDAO.getAll();
        System.out.println("Total Suppliers: " + suppliers.size());

        // Eliminar
        supplierDAO.delete(supplier.getId());
        System.out.println("Supplier eliminado. Nuevo total: " + supplierDAO.getAll().size());
    }

    private static void testVehicleDAO() throws SQLException {
        ClientDAO clientDAO = ClientDAO.getInstance();
        VehicleDAO vehicleDAO = VehicleDAO.getInstance();

        // Crear (Insertar) un cliente primero
        Client client = new Client(0, "Juan Pérez", "1234567890", "123456789", "juan@email.com");
        clientDAO.add(client);
        System.out.println("Client agregado con ID: " + client.getId());

        // Crear (Insertar) un vehículo con el client_id del cliente recién creado
        Vehicle vehicle = new Vehicle(0, client.getId(), "Toyota", "Corolla", "XYZ123", "otro");
        vehicleDAO.add(vehicle);
        System.out.println("Vehicle agregado con ID: " + vehicle.getId());

        // Leer (Consultar por ID)
        Vehicle retrievedVehicle = vehicleDAO.getById(vehicle.getId());
        System.out.println("Vehicle recuperado: " + retrievedVehicle.getModel());

        // Actualizar
        retrievedVehicle.setPlate("ABC789");
        vehicleDAO.update(retrievedVehicle);
        System.out.println("Vehicle actualizado, nueva placa: " + vehicleDAO.getById(vehicle.getId()).getPlate());

        // Consultar todos
        List<Vehicle> vehicles = vehicleDAO.getAll();
        System.out.println("Total Vehicles: " + vehicles.size());

        // Eliminar el vehículo y el cliente
        vehicleDAO.delete(vehicle.getId());
        clientDAO.delete(client.getId());
        System.out.println("Vehicle y Client eliminados. Nuevo total Vehicles: " + vehicleDAO.getAll().size());
    }*/
}
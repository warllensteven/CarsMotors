package com.carmotors.client.controller;

import com.carmotors.client.dao.ClientDAO;
import com.carmotors.client.model.Client;

public class ClientController {

    private final ClientDAO clientDAO;

    public ClientController() {
        this.clientDAO = ClientDAO.getInstance(); // Singleton
    }

    // Agregar cliente
    public void agregarCliente(Client cliente) throws Exception {
        clientDAO.add(cliente);
    }

    // Buscar cliente por ID
    public Client buscarClientePorId(int id) throws Exception {
        return clientDAO.getById(id);
    }

    // Actualizar cliente
    public void actualizarCliente(Client cliente) throws Exception {
        clientDAO.update(cliente);
    }

    // Eliminar cliente por ID
    public void eliminarCliente(int id) throws Exception {
        clientDAO.delete(id);
    }
}

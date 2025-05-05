package com.carmotors.maintenance.controller;

import com.carmotors.maintenance.dao.MaintenanceServiceDAO;
import com.carmotors.maintenance.model.MaintenanceService;
import java.sql.SQLException;
import java.util.List;

public class MaintenanceServiceController {

    private final MaintenanceServiceDAO dao;

    public MaintenanceServiceController() {
        this.dao = MaintenanceServiceDAO.getInstance();
    }

    public void agregarServicio(MaintenanceService service) throws Exception {
        dao.add(service);
    }

    public void actualizarServicio(MaintenanceService service) throws Exception {
        dao.update(service);
    }

    public void deleteService(int id) throws SQLException {
        dao.delete(id);
    }

    public MaintenanceService buscarPorId(int id) throws Exception {
        return dao.getById(id);
    }

    public List<MaintenanceService> obtenerTodos() throws Exception {
        return dao.getAll();
    }
}

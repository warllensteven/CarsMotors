package com.carmotors.maintenance.controller;

import com.carmotors.maintenance.dao.TechnicianDAO;
import com.carmotors.maintenance.model.Technician;
import java.util.List;

public class TechnicianController {

    private final TechnicianDAO dao;

    public TechnicianController() {
        this.dao = TechnicianDAO.getInstance();
    }

    public List<Technician> obtenerTodosLosTecnicos() throws Exception {
        return dao.getAll();
    }

    public Technician buscarPorId(int id) throws Exception {
        return dao.getById(id);
    }
}
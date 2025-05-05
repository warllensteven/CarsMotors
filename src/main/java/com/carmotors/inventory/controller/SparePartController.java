package com.carmotors.inventory.controller;

import com.carmotors.inventory.dao.SparePartDAO;
import com.carmotors.inventory.model.SparePart;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SparePartController {

    private SparePartDAO dao = SparePartDAO.getInstance();

    public List<SparePart> obtenerTodos() throws SQLException {
        return dao.getAll();
    }
    
    public List<SparePart> buscarPorNombre(String nombre) {
    try {
        return SparePartDAO.getInstance().searchByName(nombre);
    } catch (SQLException e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}

}

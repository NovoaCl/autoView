/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autoview.controller;

import com.mycompany.autoview.model.dao.AutoDAO;
import com.mycompany.autoview.model.dto.Auto;
import com.mycompany.autoview.service.AutoService;
import com.mycompany.autoview.view.Menu;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author clnov
 */
public class MenuController {

    private Menu vista;

    public MenuController(Menu vista) {
        this.vista = vista;
        escucharEventos();
    }

    private void escucharEventos() {
        vista.btnGuardar.addActionListener(e -> guardar());
        vista.btnLimpiar.addActionListener(e -> limpiar());
        vista.btnCargar.addActionListener(e -> cargar());
        vista.btnSalir.addActionListener(e -> salir());
    }

    private void guardar() {
        String marca = vista.txtMarca.getText();
        String color = vista.txtColor.getText();

        Auto auto = new Auto(marca, color);

        try {
            AutoService as = new AutoService();
            as.registarAuto(auto);
            JOptionPane.showMessageDialog(vista, "Auto agregado con exito");
            limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Se produjo un error: " + e);
        }
    }

    public void limpiar() {
        vista.txtMarca.setText(null);
        vista.txtColor.setText(null);
    }

 public void cargar() {
    String[] columnas = {"Marca", "Color"};
    DefaultTableModel modelo = new DefaultTableModel(columnas, 0);
    AutoDAO as = new AutoDAO();

    try {
        List<Auto> listAutos = as.listar(); // ✅ nombre correcto del método

        for (Auto a : listAutos) {
            Object[] fila = {
                a.getMarca(),
                a.getColor()
            };
            modelo.addRow(fila);
        }

        vista.tblListar.setModel(modelo); // ✅ solo una vez

    } catch (Exception e) {
        e.printStackTrace(); // ✅ muestra el error real
        JOptionPane.showMessageDialog(null, "Error al cargar datos: " + e.getMessage());
    }
}

    public void salir() {
        vista.dispose();
    }
}

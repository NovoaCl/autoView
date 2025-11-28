/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autoview.model.dao;

import com.mycompany.autoview.model.db.ConexionDB;
import com.mycompany.autoview.model.dto.Auto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AutoDAO {

    public void registro(Auto a) throws SQLException {
        String sql = "INSERT INTO auto (marca, color)"
                + "VALUES (?, ?)";
        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, a.getMarca());
            ps.setString(2, a.getColor());

            ps.executeUpdate();
        }
    }

    public List<Auto> listar() throws SQLException {
        List<Auto> lista = new ArrayList();

        String sql = "SELECT * FROM auto";

        try (Connection conn = ConexionDB.getConnection(); PreparedStatement ps = conn.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Auto a = new Auto();
                a.setMarca(rs.getString("marca"));
                a.setColor(rs.getString("color"));

                lista.add(a);
            }
        }
        return lista;
    }
    
 
}

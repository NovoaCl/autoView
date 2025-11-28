/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autoview.model.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/auto?useSSL=false&serverTimezone=America/Santiago";
    private static final String USER = "root";   // XAMPP por defecto
    private static final String PASS = "";       // normalmente vacío

    public static Connection getConnection() throws SQLException {
        try {
            // Driver MySQL 8
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            throw new SQLException("No se encontró el driver de MySQL", ex);
        }
        return DriverManager.getConnection(URL, USER, PASS);
    }

}

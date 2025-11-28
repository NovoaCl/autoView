/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.autoview.service;

import com.mycompany.autoview.model.dao.AutoDAO;
import com.mycompany.autoview.model.dto.Auto;

/**
 *
 * @author clnov
 */
public class AutoService {
    
     private final AutoDAO autodao = new AutoDAO();
    
    public void registarAuto(Auto u) throws Exception {
        if (u.getMarca() == null || u.getMarca().isBlank()) {
            throw new Exception("La marca es obigatoria");
        }
        
        autodao.registro(u);
    }
}

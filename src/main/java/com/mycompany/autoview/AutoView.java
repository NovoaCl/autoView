/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.autoview;

import com.mycompany.autoview.controller.MenuController;
import com.mycompany.autoview.view.Menu;



public class AutoView {

    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.setAlwaysOnTop(true);
        menu.setLocationRelativeTo(null);
        menu.setVisible(true);
        MenuController menucontroller = new MenuController(menu);

    }
}

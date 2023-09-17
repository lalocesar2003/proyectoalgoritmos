/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import CONTROLADORES.C_Login;
import VISTAS.IniciarSesion;

/**
 *
 * @author jlmmj
 */
public class Main {
    public static void main(String[] args) {
        IniciarSesion vista= new IniciarSesion();
        C_Login ctrl= new C_Login(vista);
        ctrl.Iniciar();
        vista.setVisible(true);
    }
}

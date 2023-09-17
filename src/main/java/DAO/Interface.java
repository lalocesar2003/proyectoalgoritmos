/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Clases.TablaHash;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract interface Interface {
    public abstract ArrayList<String[]> Cargar_datos() throws SQLException;
    public abstract TablaHash cargar_datos_locales();
}

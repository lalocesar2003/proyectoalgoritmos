/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MODELOS;

import Clases.Pila_enlazada;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jlmmj
 */
public class M_Pila {
    private final Pila_enlazada Pila=new Pila_enlazada();
    private ArrayList<String[]> my_dict = new ArrayList<>();  
    private final DefaultTableModel table_model= (DefaultTableModel)VISTAS.Pila.TBL_AREA.getModel();

    public Pila_enlazada getPila() {
        return Pila;
    }

    public ArrayList<String[]> getMy_dict() {
        return my_dict;
    }

    public void setMy_dict(ArrayList<String[]> my_dict) {
        this.my_dict = my_dict;
    } 

    public void addColumn(Object columnName) {
        table_model.addColumn(columnName);
    }

    public void setRowCount(int rowCount) {
        table_model.setRowCount(rowCount);
    }

    public void addRow(Object[] rowData) {
        table_model.addRow(rowData);
    }

    public void clearArrayList() {
        my_dict.clear();
    }

    public boolean addIntoArrayList(String[] e) {
        return my_dict.add(e);
    }
}

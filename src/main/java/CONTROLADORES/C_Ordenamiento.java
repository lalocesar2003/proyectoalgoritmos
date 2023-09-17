/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import MODELOS.M_Ordenamiento;
import VISTAS.Inicio;
import VISTAS.Ordenamiento;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author jlmmj
 */
public class C_Ordenamiento implements ActionListener {
    private final ImageIcon error = new ImageIcon(getClass().getResource("/icon/error.png"));
    private final Ordenamiento vista;
    private final M_Ordenamiento modelo;

    public C_Ordenamiento(Ordenamiento vista, M_Ordenamiento modelo) {
        this.vista = vista;
        this.modelo = modelo;
        this.vista.BTN_ORDENAR.addActionListener(this);
        this.vista.BTN_RESET.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
    
    public void Iniciar() throws SQLException, CloneNotSupportedException{
        this.vista.setLocationRelativeTo(this.vista);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
        Table("Reset", -1);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.BTN_ORDENAR)){
            if(vista.CBO_COLUMNA.getSelectedItem()=="ID"){
                int column=0;//ORDENA POR DEFECTO POR ID
                OrdenarTabla("Quick Sort", column);
            }else if(vista.CBO_COLUMNA.getSelectedItem().equals("Prioridad")){
                int column=2;//ORDENA POR DEFECTO POR ID
                OrdenarTabla("Burbúja", column);
            }else if(vista.CBO_COLUMNA.getSelectedItem().equals("Proveedor")){
                int column=3;//ORDENA POR DEFECTO POR ID
                OrdenarTabla("Selección", column);
            }else if(vista.CBO_COLUMNA.getSelectedItem().equals("Costo")){
                OrdenarTabla("Inserción", 4);
            }else if(vista.CBO_COLUMNA.getSelectedItem()=="Descripción"){
                int column=1;//ORDENA POR DEFECTO POR ID
                OrdenarTabla("Shell Sort", column);
            }else if(vista.CBO_COLUMNA.getSelectedItem()=="Razón Social"){
                int column=5;
                OrdenarTabla("Shell Sort", column);
            }
        }else if(e.getSource().equals(vista.BTN_RESET)){
            try {
                Table("Reset",0);
            } catch (CloneNotSupportedException | SQLException ex) {
                Logger.getLogger(C_Ordenamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.btnVolver)){
            Inicio view= new Inicio();
            C_Inicio ctrl= new C_Inicio(view);
            ctrl.Iniciar();
            view.setVisible(true);
            this.vista.setVisible(false);
        }
    }
    
    public void OrdenarTabla(String tipo, int columna){
        try {
            Table(tipo, columna);
        } catch (SQLException | CloneNotSupportedException ex) {
            JOptionPane.showMessageDialog(null, "Se ha generado un error", "¡ADVERTENCIA!", 0, error);
        }
    }
    
    public void Table(String tipo, int column) throws SQLException, CloneNotSupportedException{
        if(null != tipo)switch (tipo) {
            case "Reset":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.getElements());//TRAE LOS ELEMENTOS DE LA BASE DE DATOS
                modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//A LOS ELEMENTOS DE LA BASE DE DATOS LE DA AL CÓDIGO EL FORMATO
                break;
            case "Burbúja":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Burbuja(0));
                break;
            case "Selección":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Seleccion(0));
                break;
            case "Shell Sort":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Shell_sort(column));//LLAMA AL METODO SHELL SORT
                break;
            case "Quick Sort":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Quick_sort(column));//LLAMA AL METODO QUICK SORT
                break;
            case "Inserción":
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(Clases.data.Insercion(column));//LLAMA AL METODO INSERCIÓN
                break;
            default:
                break;
        }
        
        for (String []Datos : modelo.getMy_dict()){
            modelo.addRow(Datos);//AGREGA LAS FILAS AL MODELO
        }
    }
}

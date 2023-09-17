/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import MODELOS.M_Pila;
import VISTAS.ActualizarPila;
import VISTAS.Inicio;
import VISTAS.InsertarPila;
import VISTAS.Pila;
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
public class C_Pila implements ActionListener {
    private final ImageIcon check = new ImageIcon(getClass().getResource("/icon/check.png"));
    private final ImageIcon error = new ImageIcon(getClass().getResource("/icon/error.png"));
    private final ImageIcon warning = new ImageIcon(getClass().getResource("/icon/warning.png"));
    private final Pila vista;
    private final M_Pila modelo;

    public C_Pila(Pila vista, M_Pila modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnEliminar.addActionListener(this);
        this.vista.btnInsertar.addActionListener(this);
        this.vista.btnActualizar.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
        this.vista.btnBuscar.addActionListener(this);
    }
       
    public void Iniciar() throws SQLException, CloneNotSupportedException{
        this.vista.setLocationRelativeTo(this.vista);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
        Table("Reset", null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.btnInsertar)){
            InsertarPila view= new InsertarPila();
            M_Pila model= new M_Pila();
            C_InsertarPila ctrl= new C_InsertarPila(view, model);
            ctrl.Iniciar();
            view.setVisible(true);
            this.vista.setVisible(false);
        }else if(e.getSource().equals(vista.btnBuscar)){
            try {
                if(vista.txtDato.getText().trim().equals("")){throw new Error();}
                Table("Busqueda", vista.txtDato.getText());
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Pila.class.getName()).log(Level.SEVERE, null, ex);
            }catch(Error ez){
                JOptionPane.showMessageDialog(null, "No puede buscar un dato vacío.", "¡ADVERTENCIA!", 0, error);
            }
            vista.btnBuscar.setSelected(false);
        }else if(e.getSource().equals(vista.btnEliminar)){
            try {
                int index=Pila.TBL_AREA.getSelectedRow();
                if(index!=-1){
                    int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro/a que desea eliminar el elemento: " + index, "¡ATENCIÓN!", 0, 0, warning);
                    if(confirm==0){
                        modelo.getPila().Eliminar(Pila.TBL_AREA.getValueAt(index, 0).toString().replace("P", ""));
                        Table("Reset", null);
                        JOptionPane.showMessageDialog(null, "Se eliminó el elemento seleccionado con éxito", "¡LISTO!", 0, check);
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Antes debe escoger una fila a eliminar", "¡ADVERTENCIA!", 0, error);
                }
                vista.btnEliminar.setSelected(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Pila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.btnActualizar)){
            final int index=Pila.TBL_AREA.getSelectedRow();
            if(index>-1){
                String ID = Pila.TBL_AREA.getValueAt(index, 0).toString().replace("P", "");
                ActualizarPila ap = new ActualizarPila();
                C_ActualizarPila ctrl= new C_ActualizarPila(ap, ID);
                ctrl.Iniciar();
                ap.setVisible(true);
                this.vista.setVisible(false);
            }else{
                JOptionPane.showMessageDialog(null, "Antes debe escoger una fila a actualizar", "¡ADVERTENCIA!", 0, error);
            }
            this.vista.btnActualizar.setSelected(false);
        }else if(e.getSource().equals(vista.btnVolver)){
            Inicio view= new Inicio();
            C_Inicio ctrl= new C_Inicio(view);
            ctrl.Iniciar();
            view.setVisible(true);
            this.vista.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "¡UPS, parece que aún no hemos programado esa función!", "¡ADVERTENCIA!", 0);
        }
    }
    
    public void Table(String tipo, String buscar) throws SQLException, CloneNotSupportedException{
        if(null != tipo)switch (tipo) {
            case "Reset":{
                modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                modelo.setMy_dict(modelo.getPila().getDatos());//TRAE LOS ELEMENTOS DE LA BASE DE DATOS
                modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//A LOS ELEMENTOS DE LA BASE DE DATOS LE DA AL CÓDIGO EL FORMATO
                break;
            }case "Busqueda":{
                String[] result = modelo.getPila().Buscar(buscar);
                if(result!=null){
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    modelo.clearArrayList();//ELIMINA EL CONTENIDO DE LA ARRAYLIST
                    modelo.addIntoArrayList(result);//LLAMA AL METODO DE ORDENACIÓN Y PIDE UN ELEMENTO ESPECIFICO CON EL INDEX
                    modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));//LE DA EL FORMATO CORRECTO AL CÓDIGO
                }else{
                    JOptionPane.showMessageDialog(null, "El elemento buscado no se encuentra regsitrado", "¡ADVERTENCIA!", 0, error);
                    modelo.setRowCount(0);//ELIMINA LOS DATOS DE LA TABLA
                    modelo.clearArrayList();//ELIMINA LOS DATOS DE LA ARRAYLIST
                    modelo.setMy_dict(modelo.getPila().getDatos());
                    modelo.setMy_dict(Clases.data.setFormatList(modelo.getMy_dict()));
                    vista.txtDato.setText(null);
                }   break;
            }default:
                break;
        }
        
        for (String []Datos : modelo.getMy_dict()){
            modelo.addRow(Datos);//AGREGA LAS FILAS AL MODELO
        }
    }
}

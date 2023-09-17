/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import MODELOS.M_Pila;
import Clases.Pila_enlazada;
import VISTAS.ActualizarPila;
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
public class C_ActualizarPila implements ActionListener {
    private final ImageIcon check = new ImageIcon(getClass().getResource("/icon/check.png"));
    private final ImageIcon error = new ImageIcon(getClass().getResource("/icon/error.png"));
    private final ActualizarPila vista;
    private Pila_enlazada Pila = new Pila_enlazada();
    private String[] dato;

    public C_ActualizarPila(ActualizarPila vista, String ID) {
        this.vista = vista;
        this.vista.btnVolver.addActionListener(this);
        this.vista.btnGuardar.addActionListener(this);
        this.dato = this.Pila.Buscar(ID);
    }
    
    public void Iniciar(){
        this.vista.setLocationRelativeTo(vista);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
        this.setValueToTextFields();
    }
    
    private void setValueToTextFields(){
        this.vista.txtId.setText("P"+this.dato[0]);
        this.vista.txtDes.setText(this.dato[1]);
        this.vista.cboPrioridad.setSelectedItem(this.dato[2]);
        this.vista.txtProve.setText(this.dato[3]);
        this.vista.txtCosto.setText(this.dato[4]);
        this.vista.txtRaz.setText(this.dato[5]);
    }
    
    private String[] ActualizarDato(String Descripcion, String Prioridad, String Proveedor, float Costo, String Razonsocial){
        return new String[] 
        {
            vista.txtId.getText().replace("P", ""),
            Descripcion,
            Prioridad,
            Proveedor,
            String.format("%.2f",Costo),Razonsocial
        };
    }
    
    private boolean chechValidInputs(){
        return !(vista.txtDes.getText().trim()).equals("") &&
                !(vista.txtRaz.getText().trim()).equals("") &&
                !(vista.txtProve.getText().trim()).equals("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.btnVolver)){
            try {
                Pila view= new Pila();
                M_Pila model=new M_Pila();
                C_Pila ctrl= new C_Pila(view, model);
                ctrl.Iniciar();
                view.setVisible(true);
                this.vista.setVisible(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_ActualizarPila.class.getName()).log(Level.SEVERE, null, ex);
            }
        }if(e.getSource().equals(vista.btnGuardar)){
            try{
                if(!this.chechValidInputs()){throw new Error();}
                String Descripcion=vista.txtDes.getText();
                String Razonsocial=vista.txtRaz.getText().toUpperCase();
                String Proveedor=vista.txtProve.getText().toUpperCase();
                String Prioridad=vista.cboPrioridad.getSelectedItem().toString();
                float Costo = 0;
                Costo = Float.parseFloat(vista.txtCosto.getText());
                String nuevo[] = this.ActualizarDato(Descripcion, Prioridad, Proveedor, Costo, Razonsocial);
                Pila.buscarYremplazar(Integer.parseInt(nuevo[0]),nuevo);
                int response = JOptionPane.showConfirmDialog(null, "Se actualizó correctamente el dato.\n"
                        + "¿Desea volver a editar el dato?", "¡CAMBIOS APLICADOS!", 0, 0,check);
                if(response==1){
                    try {
                        Pila view = new Pila();
                        M_Pila model = new M_Pila();
                        C_Pila ctrl = new C_Pila( view, model);
                        ctrl.Iniciar();
                        view.setVisible(true);
                        vista.setVisible(false);
                    } catch (SQLException | CloneNotSupportedException ex) {
                        Logger.getLogger(C_Inicio.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null, "Solo se permiten números en el campo \"Costo\".", "¡NO VÁLIDO!", 0, error);
            }catch(Error ez){
                JOptionPane.showMessageDialog(null, "No puede dejar campos vacíos.", "¡ERROR!", 0, error);
            }
                this.Pila = new Pila_enlazada();
                this.dato = this.Pila.Buscar(vista.txtId.getText());
                this.setValueToTextFields();
                this.vista.btnGuardar.setSelected(false);
        }
    }
    
    
}

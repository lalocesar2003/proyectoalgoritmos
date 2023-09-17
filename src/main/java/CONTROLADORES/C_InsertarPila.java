package CONTROLADORES;

import MODELOS.M_Pila;
import VISTAS.InsertarPila;
import VISTAS.Pila;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class C_InsertarPila implements ActionListener{
    private final ImageIcon check = new ImageIcon(getClass().getResource("/icon/check.png"));
    private final ImageIcon error = new ImageIcon(getClass().getResource("/icon/error.png"));
    private final M_Pila modelo;
    private final InsertarPila vista;

    public C_InsertarPila(InsertarPila vista, M_Pila modelo) {
        this.modelo = modelo;
        this.vista = vista;
        this.vista.btnGuarda.addActionListener(this);
        this.vista.btnVolver.addActionListener(this);
    }
    
    public void Iniciar(){
        this.vista.setLocationRelativeTo(vista);
        this.vista.txtID.setText(getNextID());
        this.vista.txtCosto.setText("0.00");
    }
    
    private String getID(){
        return Clases.data.getTablaHash().getLastID();
    }
    
    private String getNextID(){
        return "P"+Clases.data.getTablaHash().getLastID();
    }
    
    private boolean chechValidInputs(){
        return !(vista.txtDescrip.getText().trim()).equals("") &&
                !(vista.txtRazsocial.getText().trim()).equals("") &&
                !(vista.txtProveedor.getText().trim()).equals("");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.btnGuarda)){         
            try{
                if(!this.chechValidInputs()){throw new Error();}
                String Descripcion=vista.txtDescrip.getText();
                String Razonsocial=vista.txtRazsocial.getText().toUpperCase();
                String Proveedor=vista.txtProveedor.getText().toUpperCase();
                String Prioridad=vista.cboPrioridad.getSelectedItem().toString();
                float Costo = 0;
                Costo = Float.parseFloat(vista.txtCosto.getText());
                String dato[] = {this.getID(),Descripcion,Prioridad,Proveedor,String.format("%.2f",Costo),Razonsocial};
                modelo.getPila().Insertar(dato);
                modelo.getPila().EnviarDatos();
                System.out.println("Cantidad de elementos en la lista --> "+modelo.getPila().getnElementos());
                int response = JOptionPane.showConfirmDialog(null, "Se agregó correctamente el dato.\n"
                        + "¿Desea ingresar un nuevo dato?", "¡ATENCIÓN!", 0, 0, check);
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
            }catch(NumberFormatException  ex){
                JOptionPane.showMessageDialog(null, "Solo se permiten números en esta sección", "¡ATENCIÓN!", 0, error);
            }catch(Error ez){
                JOptionPane.showMessageDialog(null, "No puede dejar campos vacíos.", "¡ATENCIÓN!", 0, error);
            }
                vista.txtID.setText(getNextID());
                vista.txtDescrip.setText(null);
                vista.txtRazsocial.setText(null);
                vista.txtProveedor.setText(null);
                vista.cboPrioridad.setSelectedIndex(1);
                vista.txtCosto.setText("0.00");
                vista.btnGuarda.setSelected(false);
        }else if(e.getSource().equals(vista.btnVolver)){
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
        }else{
            JOptionPane.showMessageDialog(null, "¡UPS, parece que aún no hemos programado esa función!", "¡ADVERTENCIA!", 0);
        }
    }
}

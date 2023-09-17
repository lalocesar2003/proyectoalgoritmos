package CONTROLADORES;

import MODELOS.M_Listar;
import MODELOS.M_Ordenamiento;
import MODELOS.M_Pila;
import VISTAS.Buscar;
import VISTAS.Cola;
import VISTAS.IniciarSesion;
import VISTAS.Inicio;
import VISTAS.Listar;
import VISTAS.Ordenamiento;
import VISTAS.Pila;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jlmmj
 */
public class C_Inicio implements ActionListener {
    private final Inicio vista;

    public C_Inicio(Inicio vista) {
        this.vista = vista;
        this.vista.BTN_BUSCAR.addActionListener(this);
        this.vista.BTN_COLA.addActionListener(this);
        this.vista.BTN_LISTAR.addActionListener(this);
        this.vista.BTN_ORDENAMIENTO.addActionListener(this);
        this.vista.BTN_PILA.addActionListener(this);
        this.vista.BTN_LOGOUT.addActionListener(this);
    }
    
    public void Iniciar(){
        vista.setLocationRelativeTo(vista);
        vista.getContentPane().setBackground(new Color(0, 102, 102));
        Clases.data.setElements();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.BTN_BUSCAR)){
            try {
                Buscar view = new Buscar();
                C_Buscar ctrl = new C_Buscar(view);
                ctrl.iniciar();
                view.setVisible(true);
                vista.setVisible(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.BTN_COLA)){
            Cola cola = new Cola();
            cola.setVisible(true);
            this.vista.setVisible(false);
        }else if(e.getSource().equals(vista.BTN_LISTAR)){
            try {
                Listar view= new Listar();
                M_Listar model= new M_Listar();
                C_Listar ctrl= new C_Listar(view, model);
                ctrl.Iniciar();
                view.setVisible(true);
                this.vista.setVisible(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.BTN_LOGOUT)){
            IniciarSesion view= new IniciarSesion();
            C_Login ctrl= new C_Login(view);
            ctrl.Iniciar();
            view.setVisible(true);
            this.vista.setVisible(false);
        }else if(e.getSource().equals(vista.BTN_ORDENAMIENTO)){
            try {
                Ordenamiento view= new Ordenamiento();
                M_Ordenamiento model= new M_Ordenamiento();
                C_Ordenamiento ctrl= new C_Ordenamiento(view, model);
                ctrl.Iniciar();
                view.setVisible(true);
                this.vista.setVisible(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(e.getSource().equals(vista.BTN_PILA)){
            try {
                Pila view = new Pila();
                M_Pila modelo = new M_Pila();
                C_Pila ctrl = new C_Pila( view, modelo);
                ctrl.Iniciar();
                view.setVisible(true);
                vista.setVisible(false);
            } catch (SQLException | CloneNotSupportedException ex) {
                Logger.getLogger(C_Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(null, "¡UPS, al parecer aún no hemos programado esa función!", "¡ADVERTENCIA!", 0);
        }
    }
    
}

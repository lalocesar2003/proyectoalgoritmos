/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CONTROLADORES;

import VISTAS.IniciarSesion;
import VISTAS.Inicio;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.awt.image.ImageObserver.HEIGHT;
import static java.awt.image.ImageObserver.WIDTH;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author jlmmj
 */
public class C_Login implements ActionListener {
    private final IniciarSesion vista;
    private final Clases.Usuarios users;

    public C_Login(IniciarSesion vista) {
        this.vista = vista;
        this.vista.btnLogin.addActionListener(this);
        this.vista.btnExit.addActionListener(this);
        this.users = Clases.data.getUsersClass();
    }
    
    public void Iniciar(){
        this.vista.setLocationRelativeTo(null);
        this.vista.getContentPane().setBackground(new Color(0, 102, 102));
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir")+"\\src\\main\\java\\ico\\login-ico-48x48.png");   
        JLabel userLabel = new JLabel("Full Name :", icon, JLabel.LEFT);
        this.vista.getContentPane().add(userLabel);
        this.vista.getRootPane().setDefaultButton(this.vista.btnLogin);
    }
            
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(vista.btnLogin)){
            String user, pass;
            user = this.vista.txtUser.getText();
            pass = this.vista.txtPass.getText();
            if(!users.existsUsers() && users.checkDefaultCredentials(user, pass)){
                Inicio view = new Inicio();
                C_Inicio ctrl = new C_Inicio(view);
                ctrl.Iniciar();
                view.setVisible(true);
                this.vista.setVisible(false);
            }
            else if(users.login(user, pass)){
                Inicio view = new Inicio();
                C_Inicio ctrl = new C_Inicio(view);
                ctrl.Iniciar();
                view.setVisible(true);
                this.vista.setVisible(false);
            }
            else{
                ImageIcon icon = new ImageIcon(getClass().getResource("/icon/error.png"));
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecta", "¡CREDENCIALES NO VÁLIDAS!", HEIGHT, icon);
            }
            vista.btnLogin.setSelected(false);
        }else if(e.getSource().equals(vista.btnExit)){
            System.exit(0);
        }else{
            JOptionPane.showMessageDialog(null, "¡UPS, parece que aún no hemos programado esa función!", "¡ADVERTENCIA!", WIDTH);
        }
    }
    
}

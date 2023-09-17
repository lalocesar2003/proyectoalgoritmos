/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;


/**
 *
 * @author jlmmj
 */
public class Usuarios {
    private final Lista_enlazada users;
    private int nUsuarios;

    public Usuarios(Lista_enlazada users) {
        this.users = users;
        this.nUsuarios = 0;
    }
    
    public void addUser(String usr, String pass){
        final String[] credentials = {usr, pass};
        users.agregarFinal(credentials);
        nUsuarios++;
    }
    
    public boolean login(String usr, String pass){
        final String[] credentials = {usr, pass};
        return users.Buscar(credentials);
    }
    
    public boolean existsUsers(){
        return nUsuarios>0;
    }
    
    public boolean checkDefaultCredentials(String usr, String pass){
        return usr.equals("admin23")&&pass.equals("12345");
    }
}

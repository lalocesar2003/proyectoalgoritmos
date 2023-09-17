/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

/**
 *
 * @author LAB-USR-AQ265-A0302
 */
public class NArbol {
    /* DECLARACIÓN DE VARIABLES */
    private int dato;
    private NArbol der;
    private NArbol izq;
    
    /* CONSTRUCTOR */
    public NArbol(int dato) {
        this.dato = dato;
        this.der = null;
        this.izq = null;
    }
    
    /* MÉTODOS */
    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NArbol getDer() {
        return der;
    }

    public void setDer(NArbol der) {
        this.der = der;
    }

    public NArbol getIzq() {
        return izq;
    }

    public void setIzq(NArbol izq) {
        this.izq = izq;
    }

    public void visitar(){
        
    }
    
    public NArbol subArbolDer(){
        return this.getDer();
    }
    
    public NArbol subArbolIzq(){
        return this.getIzq();
    }
}

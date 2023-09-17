package Clases;

public class Nodo {
    //DECLARACION DE VARAIBLES
    private String[] dato;
    private Nodo siguienteNodo;

    //CONSTRUCTORES
    public Nodo(String[] dato) {
        this.dato = dato;
        this.siguienteNodo = null;
    }
    
    public Nodo(String[] dato, Nodo siguienteNodo) {
        this.dato = dato;
        this.siguienteNodo = siguienteNodo;
    }
    
    //GETTER & SETTER

    public String[] getDato() {
        return dato;
    }

    public void setDato(String[] dato) {
        this.dato = dato;
    }

    public Nodo getSiguienteNodo() {
        return siguienteNodo;
    }

    public void setSiguienteNodo(Nodo siguienteNodo) {
        this.siguienteNodo = siguienteNodo;
    }
    
}

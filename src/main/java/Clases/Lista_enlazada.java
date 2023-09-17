package Clases;

import java.util.Arrays;

public class Lista_enlazada {
    private static Nodo inicio, fin;
    
    public Lista_enlazada(){
        inicio = null;
        fin = null;
    }

    public void agregarInicio(String[] dato){
        inicio = new Nodo(dato, inicio);
        if(fin == null){
            fin = inicio;
        }
    }
    
    public void mostrarElementos(){
        Nodo elemento = inicio;
        System.out.println("EXECUTING VOID mostrarElementos:");
        while(elemento!=null){
            if(elemento.getSiguienteNodo()!=null){
                System.out.print(Arrays.toString(elemento.getDato())+" --> ");
            }else{
                System.out.print(Arrays.toString(elemento.getDato()));
            }
            elemento = elemento.getSiguienteNodo();
        }
        System.out.println();
        System.out.println("EXECUTION VOID SUCESS");
    }
    
    public boolean estaVacio(){
        return inicio==null;
    }
    
    //Metodo para agregar un dato al final del nodo   
    public void agregarFinal(String[] dato){
        if(estaVacio()) {
        inicio = fin = new Nodo(dato);
        }
        else {
         fin.setSiguienteNodo(new Nodo(dato));
         fin = fin.getSiguienteNodo();
        }        
    }
    
    //Metodo para buscar 
    public boolean Buscar(String[] credentials){
        Nodo bus = inicio;
        while(bus != null){
            if(Arrays.equals(bus.getDato(), credentials))
                return true;
            bus = bus.getSiguienteNodo();
        }
        return false;
    }
    
    //Método para eliminar un elemento del inicio
    public void eliminarIni(){
        Nodo tem = inicio;
        String [] eli = tem.getDato();
        
        if(inicio == fin){
            inicio = null;
            fin = null;
        }
        else {
            inicio = tem.getSiguienteNodo();
            System.out.println("<--- " + Arrays.toString(eli) + " fue eliminado con éxito");
        }  
    }
    
    //Método para eliminar un elemento del final
    public void eliminarFin(){
        Nodo tem = fin;
        String[] eli = tem.getDato();
        
        if(inicio == fin){
            inicio = null;
            fin = null;
        }
        else{
            Nodo temini = inicio;
            while(temini.getSiguienteNodo() != fin){
                temini = temini.getSiguienteNodo();
            }
            fin = temini;
            fin.setSiguienteNodo(null);
            System.out.println("<--- " + Arrays.toString(eli) + " fue eliminado con éxito ---->");
        }
    }
    
    //Método para retornar el dato que contiene el Nodo
    public String[] getDato(){
        return inicio.getDato();
    }
    
    public void getSiguiente(){
        Nodo tem = inicio;
        inicio = tem.getSiguienteNodo();
    }
}

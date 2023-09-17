package Clases;

import java.util.ArrayList;

/**
 *
 * @author jlmmj
 */
public class Pila_enlazada {
    private Nodo inicio;
    private int nElementos;

    public Pila_enlazada() {
        this.inicio = null;
        this.nElementos = 0;
        this.cargar_datos();
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public int getnElementos() {
        return nElementos;
    }

    public String[] getDato() {
        this.cargar_datos();
        return this.inicio.getDato();
    }

    public void getSiguiente() {
        this.inicio = this.inicio.getSiguienteNodo();
    }
    
    public void Insertar(String[] dato){
        Nodo nuevo= new Nodo(dato);
        dato[0]=dato[0].replace("P", "");
        nuevo.setSiguienteNodo(inicio);
        this.inicio=nuevo;
        nElementos++;
    }
    
    public ArrayList<String[]> getDatos(){
        ArrayList<String[]> datos= new ArrayList<>();
        Nodo temp= inicio;
        while(temp!=null){
            datos.add(temp.getDato());
            temp=temp.getSiguienteNodo();
        }
        return datos;
    }
    
    public void cargar_datos(){
        for(String[] datos : Clases.data.getTablaHash().getNotNullData()){
            this.Insertar(datos);
        }
    }
    
    public void EnviarDatos(){
        ArrayList<String[]> lista= new ArrayList<>();
        Nodo temp= inicio;
        String[][] data = Clases.data.getTablaHash().getNotNullData();
        while(temp!=null){
            boolean exists = false;
            for (String[] array : data) {
                if (array == temp.getDato())
                    exists = true;
            }
            if(!exists)
                lista.add(temp.getDato());
            temp=temp.getSiguienteNodo();
        }
        Clases.data.updateElements(lista);
    }
    
    public String[] Buscar(String ID){
        ID=ID.replace("P", "");
        Nodo temp= inicio;
        String[] dato=null;
        while(temp!=null){
            int ID_temp = Integer.parseInt(temp.getDato()[0].replace("P", ""));
            if(ID_temp==Integer.parseInt(ID)){
                dato=temp.getDato().clone();
                break;
            }
            temp=temp.getSiguienteNodo();
        }
        return dato;
    }
    
    public void Eliminar(String ID){
        Nodo temp= inicio;
        ArrayList<String[]> nuevo= new ArrayList<>();
        while(temp!=null){
            if(!temp.getDato()[0].equals(ID) ){
                nuevo.add(temp.getDato());
            }else{
                nElementos--;
            }
            temp=temp.getSiguienteNodo();
        }
        this.resetPila();
        for(String[] dato: nuevo){
            this.Insertar(dato);
        }
        Clases.data.getTablaHash().deleteElement(ID);
    }
    
    public void buscarYremplazar(int ID, String[] nuevo){
        Clases.data.getTablaHash().editElement(ID, nuevo);
    }
    
    private void resetPila(){
        inicio=null;
        nElementos=0;
    }
    
}

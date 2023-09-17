/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author jlmmj
 */
public class TablaHash {
    private static String[][] arreglo;
    int tamanio, contador;
    private boolean isInitialized = false;
    
    //Constructor

    public TablaHash(int tam) {
        tamanio = tam;//Estamos inicializando el tamaño
        arreglo = new String[tam][];
        contador=0;
    }
    
    public boolean isInitialized(){
        return this.isInitialized;
    }
    
    public void agregar(String[] cadenaArreglo){
        isInitialized = true;
        String[] elemento = cadenaArreglo; 
        int indiceArreglo = Integer.parseInt(elemento[0]) % 97;
        System.out.println("El indice es "+ indiceArreglo +" Para el elemento "+ Arrays.toString(elemento));
        //Tratando las colisiones
        while(arreglo[indiceArreglo]!=null){
            indiceArreglo++;
            System.out.println("Ocurrió una colisión en el indice " +(indiceArreglo-1)+ " Cambiar a indice " +indiceArreglo);
            indiceArreglo%=tamanio;
        }
        arreglo[indiceArreglo]=elemento;
        contador++;
    }
    
    //Método para buscar Clave
    public String[] buscarClave(String elemento) {
        int indiceArreglo = Integer.parseInt(elemento) % 7;
        int count = 0;
        while(arreglo[indiceArreglo]!=null){
            if(arreglo[indiceArreglo] == null ? elemento == null : arreglo[indiceArreglo][0].equals(elemento))
            {
                System.out.println("El elemento " + elemento + " Fue encontrado por el Índice " + indiceArreglo);
                this.printIndice(indiceArreglo);
                return arreglo[indiceArreglo];
            }
            indiceArreglo++;
            indiceArreglo%=tamanio;
            count++;
            if(count > 7){
                break;
            }
        }
        return null;
    }
    
    public String getLastID(){
        int ID=0;
        for (String[] arreglo1 : arreglo) {
            if(arreglo1!=null){
                final int arregloID = Integer.parseInt(arreglo1[0]);
                if(ID<arregloID)
                    ID=arregloID;
            }
        }
        ID++;
        if(ID>99)
            return Integer.toString(ID);
        else if(ID>9){
            return "0"+ID;
        }else{
            return "00"+ID;
        }
    }
    
    public String[][] getData(){
        return TablaHash.arreglo;
    }
    
    public String[][] getNotNullData(){
        final ArrayList<String[]> temp = new ArrayList<>();
        for (String[] array:arreglo) {
            if(array!=null)
                temp.add(array);
        }
        final String[][] result =new String[temp.toArray().length][];
        for (int i = 0; i < temp.toArray().length; i++) {
            result[i]=temp.get(i);
        }
        return result;
    }
    
    public void printIndice(int index){
        System.out.println(Arrays.toString(arreglo[index]));
    }
    
    public void deleteElement(String ID){
        arreglo[Integer.parseInt(ID)]=null;
    }
    
    public void editElement(int ID, String[] nuevo){
        arreglo[ID]=nuevo;
    }
}

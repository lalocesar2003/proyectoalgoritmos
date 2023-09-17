/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.ArrayList;


/**
 *
 * @author jlmmj
 */
public class Cola_Pendientes {
    private static final int MAX = 25;
    private static final String[][] pendientes = new String[MAX][];
    private static int LastID = 0;
    private static int fin = -1;

    public static int size() {
        return fin;
    }

    public static boolean isEmpty() {
        return pendientes[0]==null;
    }
    
    public static boolean isFull(){
        return fin==MAX-1;
    }

    public static void add(String[] e) {
        LastID = Integer.parseInt(e[0].replace("N", ""));
        fin++;
        pendientes[fin]=e;
    }

    public static void remove(int index) {
        fin--;
        pendientes[index]=null;
        for (int i = 0; i < MAX-1; i++) {
            if(pendientes[i] ==null && pendientes[i+1] !=null){
                pendientes[i]=pendientes[i+1];
                pendientes[i+1]=null;
            }
        }
    }

    public static void clear() {
        for (int i = 0; i < 26; i++) {
            pendientes[i]=null;
        }
    }    

    public static int getLastID() {
        return LastID;
    }
    
    public static String[] getLastData(int ID){
        for (int i = 0; i <= fin; i++) {
            if(pendientes[i]!=null){
                if(Integer.parseInt(pendientes[i][0].replace("N", ""))==ID)
                    return pendientes[i];
            }
        }
        return null;
    }
    
    public static String[] getData(int index){
        return pendientes[index];
    }
    
    public static void setData(int index, String[] dato){
        pendientes[index]=dato;
    }
    
    public static ArrayList<String[]> getTerminados(){
        ArrayList<String[]> temp = new ArrayList<>();
        for (int i = 0; i < MAX; i++) {
            if(pendientes[i]!=null){
                if(pendientes[i][6].equals("TERMINADO")){
                    final String[] dato = pendientes[i];
                    dato[0]=Clases.data.getTablaHash().getLastID();
                    dato[6]=null;
                    temp.add(dato);
                    Cola_Pendientes.remove(i);
                }
            }
        }
        return temp;
    }
    
    public static void removeCancelados(){
        for (int i = 0; i < MAX; i++) {
            if(pendientes[i]!=null){
                if(pendientes[i][6].equals("CANCELADO")){
                    Cola_Pendientes.remove(i);
                }
            }
        }
    }
    
}

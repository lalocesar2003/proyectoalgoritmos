package DAO;

import Clases.TablaHash;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jlmmj
 */
public class Implement extends MySQLConexion implements Interface {
    
    @Override
    public ArrayList<String[]> Cargar_datos() {
        System.out.println("STATIC CLASS DESCARGA_DATOS SUCESS");
        ArrayList<String[]> datos = new ArrayList<>();
        try{
            Connection conn = getConexion();
            String SQL = "select * from orden_servicio";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(SQL);
            while(rs.next()){
                String data[] = {
                    rs.getString("COD_PRO").replace("P", ""),
                    rs.getString("DESC_PRO"),
                    rs.getString("prioridad"),
                    rs.getString("proveedor"),
                    rs.getString("PRECIO_PRO"),
                    rs.getString("razon_social"),
                };
                datos.add(data);
            }
        }catch(SQLException e){
            System.out.println(e);
        }finally{
            Collections.shuffle(datos);
            return datos;
        }
    }

    @Override
    public TablaHash cargar_datos_locales() {
        TablaHash Hash= new TablaHash(100);
        Hash.agregar(new String[] {"065","MANTENIMIENTO PREVENTIVO LUCES DE EMERGENCIA, SENSOR DE HUMO","MEDIA","JULIO JAUREGUI","0.00","CPJ"});
        Hash.agregar(new String[] {"001", "Cambio de lona y fluorescentes", "MEDIA", "ECOGEN", "900.15", "JEL"});
        Hash.agregar(new String[] {"055","PUERTA DE CAJA CON CORREDIZAS DAÃ‘ADAS, PUERTA DESENTRADA REPARAR TAPA DE CAJA, COLOCAR BOVEDA EN CAJA SOLO INSTALACIÃ“N","MEDIA","C&TVentas y Servicios Generales EIRL","339.25","CPJ"});
        Hash.agregar(new String[] {"034","Conexiones Hdmi juegos virtuales con spliter a pc central /// problemas con una pantalla zona deportiva HDMI","MEDIA","GARANTIA","0.00","LOCALES AT"});
        Hash.agregar(new String[] {"006", "PROBLEMAS DE CONEXION DE HDMI", "MEDIA", "GARANTIA", "0.00", "LOCALES AT"});
        Hash.agregar(new String[] {"009", "SUMINISTRO E INSTALACION DE LUMINARIA ", "MEDIA", "LUGONI", "171.76", "CPJ"});
        Hash.agregar(new String[] {"036","PINTADO DE TIENDA ","MEDIA","PROYECTO SAN MIGUEL","1500.00","LOCALES AT"});
        Hash.agregar(new String[] {"052","CHAPA DE CAJA NO FUNCIONA Y CHAPA DE TERMINAL NO FUNCIONA","MEDIA","C&TVentas y Servicios Generales EIRL","89.09","LOCALES AT"});
        Hash.agregar(new String[] {"063","PROBLEMAS CON TIMER Y ENCENDIDO DE LETRERO PUBLICITARIO","BAJA","JULIO JAUREGUI","0.00","LOCALES AT"});
        Hash.agregar(new String[] {"042","MANTENIMIENTO CORRECTIVO ","ALTA","GARANTIA","1062.00","LOCALES AT"});
        Hash.agregar(new String[] {"011", "PINTADO DE MUROS ", "MEDIA", "PROYECTO SAN MIGUEL ", "1500.20", "LOCALES AT"});
        Hash.agregar(new String[] {"045","DESMONTAJE E INSTALACION DE MARCO METALICO ","MEDIA","GARANTIA","120.00","CPJ"});
        Hash.agregar(new String[] {"008", "Conexiones Hdmi juegos virtuales con spliter a pc central-problemas con una pantalla zona deportiva HDMI", "MEDIA", "GARANTIA", "0.00", "LOCALES AT"});
        Hash.agregar(new String[] {"053","CORREDIZAS DE CAJON SE ATASCAN, PUERTA CORREDIZA DE CAJA EN MAL ESTADO DESENTRADA, DIFICULTA PARA ABRIR Y CERRAR","MEDIA","C&TVentas y Servicios Generales EIRL","221.25","LOCALES AT"});
        Hash.agregar(new String[] {"054","CAMBIO DE CHAPAS EN CAJON POR MOTIVOS Y COLOCAR PUERTA EN CAJA","MEDIA","C&TVentas y Servicios Generales EIRL","280.25","JEL"});
        Hash.agregar(new String[] {"029","Suministro e implementaciÃ³n de tablero nuevo ","ALTA","ESINEEL","1224.84","LOCALES AT"});
        Hash.agregar(new String[] {"003", "Cambio de lona", "MEDIA", "ECOGEN", "900.73", "CPJ"});
        Hash.agregar(new String[] {"046","DESMONTAJE E INSTALACION DE 1 TV","MEDIA","PROYECTOS INVERSIONES SAN MIGUEL SAC","120.00","LOCALES AT"});
        Hash.agregar(new String[] {"004", "Suministro e implementaciÃ³n de tablero nuevo ", "ALTA", "ESINEEL", "1225.75", "LOCALES AT"});
        Hash.agregar(new String[] {"049","CAMBIO DE LUMINARIA","MEDIA","JULIO JAUREGUI","0.00","OPERACIONES AT"});
        Hash.agregar(new String[] {"016", "MANTENIMIENTO CORRECTIVO ", "ALTA", "GARANTIA", "1062.21", "LOCALES AT"});
        Hash.agregar(new String[] {"057","MANTENIMIENTO DE PISOS, PINTADO DE PAREDES Y REPARACION DE DRIWALL","MEDIA","ECOGEN","950.00","CPJ"});
        Hash.agregar(new String[] {"061","MANTENIMIENTO PREVENTIVO POZO A TIERRA","MEDIA","WANG","0.00","LOCALES AT"});
        Hash.agregar(new String[] {"005", "PROBLEMAS DE VISIBILIDAD DE CAMARAS ", "ALTA", "GARANTIA", "0.00", "LOCALES AT"});
        Hash.agregar(new String[] {"032","PROBLEMAS DE CONEXION DE HDMI","MEDIA","GARANTIA","0.00","LOCALES AT"});
        Hash.agregar(new String[] {"056","TVs no prenden","MEDIA","Julio Jauregui","0.00","LOCALES AT"});
        Hash.agregar(new String[] {"015", "CAMBIO DE 2 LUMINARIAS", "MEDIA", "GARANTIA", "0.00", "LOCALES AT"});
        Hash.agregar(new String[] {"037","PINTADO DE MUROS ","MEDIA","PROYECTO SAN MIGUEL","1500.00","LOCALES AT"});
        Clases.Cola_Pendientes.add(new String[] {"N01","Teléfono Huawei P40 PRO no enciende","BAJA","GARANTIA","0.00","Rippley","PENDIENTE"});
        Clases.Cola_Pendientes.add(new String[] {"N02","Horno 540Watts dejó de funcionar","MEDIA","LUGONI","150.00","LUGONI","PENDIENTE"});
        Clases.Cola_Pendientes.add(new String[] {"N03","Router Asus ROG WiFi6 antena no descompuesta","BAJA","GARANTIA","0.00","Tottus","PENDIENTE"});
        return Hash;
    }
    
}
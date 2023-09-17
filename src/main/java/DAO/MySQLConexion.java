package DAO;

import java.sql.*;

public class MySQLConexion {
    public static Connection getConexion(){ 
        Connection con = null;
        try{ 
            Class.forName("com.mysql.jdbc.Driver"); 
            String url = "jdbc:mysql://localhost/bdalgoritmo"; 
            String usr = "root";
            String psw = ""; 
            con = DriverManager.getConnection(url,usr,psw); 
            System.out.println("conexion... OK");
        }catch(ClassNotFoundException ex){ 
            System.out.println("No hay Driver!!");
        }catch(SQLException ex){ 
            System.out.println("Error con la BD "); 
        }finally{
            return con;
        }
    }
}


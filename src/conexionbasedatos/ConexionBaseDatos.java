/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionbasedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Katsuo
 */
public class ConexionBaseDatos {
    
    private static final String USUARIO = "root";//nombre del usuario en su equipo
    private static final String CONTRASENIA = "";//contrasenia del usuario que ingresamos arriba
    private static final String BASE_DATO = "primer_db";//nombre de la base de datos a usar
    private static final String URL = "jdbc:mysql://localhost/"+BASE_DATO+"?autoReconnect=true&useSSL=false";//la direccion para la conexion a la base de datos
    
    private static final String TABLA = "jugadores";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Connection conexionPrimerDB = null;
        try {//intenta conectarte a la base de datos
            conexionPrimerDB = DriverManager.getConnection(URL, USUARIO, CONTRASENIA);
            System.out.println("Conexion correcta a la base de datos");
            
            //preparamos un comando sql
            PreparedStatement pstm = conexionPrimerDB.prepareStatement("SELECT * FROM "+ TABLA);
            
            //guardamos el resultado del comando definido previamente en rs
            ResultSet rs = pstm.executeQuery();
            
            //manejar la informacion obtenida del comando ejecutado mediante rs
            while( rs.next()){
                System.out.println("---Jugador ID " + rs.getInt("id_jugador") + "---");
                System.out.println("Nombre: " + rs.getString("nombre"));
                System.out.println("Experiencia: " + rs.getFloat("experiencia"));
            }
            
            
        } catch (SQLException ex) {// y si sale mal, acá lo manejamos
            System.out.println("Algo malio sal"+ ex);
        }
        
        
    }
    
}

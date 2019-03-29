package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SALAZAR
 */
public class Conexion {
    
    private static final String HOST = "localhost";
    private static final String DB = "sakila";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    
    public static Connection getMySqlConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String connectionUrl = "jdbc:mysql://"+HOST+"/"+DB;
            Connection con = DriverManager.getConnection(connectionUrl, USER, PASSWORD);
            
            return con;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    } 
    
}

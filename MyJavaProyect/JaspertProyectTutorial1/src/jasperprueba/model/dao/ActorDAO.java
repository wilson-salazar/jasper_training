/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasperprueba.model.dao;

import com.sun.istack.internal.logging.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import modelo.Actor;
import prueba.Conexion;
import sun.util.logging.PlatformLogger;

/**
 *
 * @author SALAZAR
 */
public class ActorDAO {
    
    public List<Actor> getAllActores(){
        List<Actor> listaActores = new ArrayList<>();
        
        try {
            String query = "Select * from actor";
            Connection c = Conexion.getMySqlConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet re = ps.executeQuery();
            System.out.println("Lista actores row >>>>>>>>>>>> " + re.getRow());
            while(re.next()){
                Actor actor = new Actor();
                actor.setNombre(re.getString("last_name"));
                actor.setApellido(re.getString("first_name"));
                listaActores.add(actor);
            }
            System.out.println("Lista actores tamaño >>>>>>>>>>>> " + listaActores.size());
            c.close();
            
        } catch (SQLException e) {
            Logger.getLogger(ActorDAO.class).log(Level.SEVERE, null, e);
        }
        
        return listaActores;
    }
    
}

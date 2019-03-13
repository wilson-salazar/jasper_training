/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasperprueba.model.dao;

import jasperprueba.model.Actor;
import jasperprueba.model.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gianmarco Tantaruna
 */
public class ActorDAO {
    
    public List<Actor> leerTodo(){
        List<Actor> lista = new ArrayList<>();
        try {            
            String query = "SELECT * FROM actor";
            Connection c = Conexion.getMySQLConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Actor actor = new Actor();
                actor.setApellidos(rs.getString("last_name"));
                actor.setNombre(rs.getString("first_name"));
                lista.add(actor);
            }
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(ActorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
}

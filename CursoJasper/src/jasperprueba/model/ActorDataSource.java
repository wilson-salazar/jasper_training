/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasperprueba.model;

import jasperprueba.model.dao.ActorDAO;
import java.util.List;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;

/**
 *
 * @author Gianmarco Tantaruna
 */
public class ActorDataSource implements JRDataSource{
    private List<Actor> actores;
    private int contador;
    
    public ActorDataSource(){
        ActorDAO dao = new ActorDAO();
        actores = dao.leerTodo();
        contador = -1;
    }
    
    
    /**
     * while(next()){
     *  //getfieldvalue tantas veces como fields haya en el reporte
     * }
     */
    @Override
    public boolean next() throws JRException {
        contador++;
        return contador<actores.size();
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        Actor actor = actores.get(contador);
        //JRField representa un campo (field) en EL REPORTE
        if(jrf.getName().equals("nombre")){
            return actor.getNombre();
        }
        else if(jrf.getName().equals("apellido")){
            return actor.getApellidos();
        }
        return null;
    }
    
}

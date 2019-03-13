/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasperprueba;

import jasperprueba.model.Actor;
import jasperprueba.model.ActorDataSource;
import jasperprueba.model.Conexion;
import jasperprueba.model.dao.ActorDAO;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Gianmarco Tantaruna
 */
public class ReportGenerator {
    public static final String REPORTE_SIMPLE_PELICULAS = "ReporteSimplePeliculas.jasper";
    public static final String REPORTE_CON_PARAMETRO = "ReporteRatingConParametro.jasper";
    public static final String REPORTE_SIMPLE_ACTORES = "ReporteSimpleActores.jasper";
    
    public static JasperPrint generarReporteSimplePeliculas(){
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORTE_SIMPLE_PELICULAS, new HashMap(), Conexion.getMySQLConnection());
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static JasperPrint generarReportePorRating(String rating){
        try {
            HashMap<String,Object> parametros = new HashMap<>();
            parametros.put("rating_reporte", rating);
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORTE_CON_PARAMETRO, parametros, Conexion.getMySQLConnection());
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    public static JasperPrint generarReporteActores(){
        try {
            ActorDAO dao = new ActorDAO();
            //List<Actor> actores = dao.leerTodo();
            //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(actores);
            JRDataSource dataSource = new ActorDataSource();
            JasperPrint reporteLleno = JasperFillManager.fillReport(REPORTE_SIMPLE_ACTORES, new HashMap(), dataSource);
            return reporteLleno;
        } catch (JRException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}

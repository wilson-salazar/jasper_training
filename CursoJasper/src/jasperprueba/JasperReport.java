/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jasperprueba;

import jasperprueba.model.dao.ActorDAO;
import java.net.Socket;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Gianmarco Tantaruna
 */
public class JasperReport {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JRException{
        JasperPrint reporteLeno = ReportGenerator.generarReporteActores();
        //JasperExportManager.exportReportToPdfFile(reporteLeno,"ReportePorRating.pdf");
        JasperViewer viewer = new JasperViewer(reporteLeno);
        viewer.setVisible(true);
    }
    
    
}

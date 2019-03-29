/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prueba;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author SALAZAR
 */
public class JaspertReport {
    
    public static void main(String [] args) throws JRException{
        //JasperPrint reporteLleno = ReportGenerator.generarReportePorRating("NC-17");
        JasperPrint reporteLleno = ReportGenerator.generarReporteActores();
        //JasperExportManager.exportReportToPdfFile(reporteLleno, "ReportePorRating.pdf");
        
        
//        Exportar en modo escritorio
        JasperViewer viewer = new JasperViewer(reporteLleno);
        viewer.setVisible(true);
    
    }
    
}

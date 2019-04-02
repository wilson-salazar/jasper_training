package prueba;

import jasperprueba.model.dao.ActorDAO;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Actor;
import modelo.ActorDataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author SALAZAR
 */
public class ReportGenerator {

    public static final String REPORTE_SIMPLE_PELICULAS = "ReporteSimplePeliculas.jasper";
    public static final String REPORTE_CON_PARAMETROS = "ReporteRatingConParametro.jasper";
    public static final String REPORTE_SIMPLE_ACTORES = "ReporteSimpleActores.jasper";

    public static JasperPrint generarReporteSimplePelicula() {
        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(
                    REPORTE_SIMPLE_PELICULAS,
                    new HashMap<>(),
                    Conexion.getMySqlConnection());

            return reporteLleno;

        } catch (JRException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint generarReportePorRating(String rating) {
        HashMap<String, Object> paramtros = new HashMap<>();
        paramtros.put("rating_reporte", rating);

        try {
            JasperPrint reporteLleno = JasperFillManager.fillReport(
                    REPORTE_CON_PARAMETROS,
                    paramtros,
                    Conexion.getMySqlConnection());

            return reporteLleno;

        } catch (JRException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static JasperPrint generarReporteActores() {

        try {
            ActorDAO dao = new ActorDAO();
            //List<Actor> listaActores = dao.getAllActores();
            //System.out.println("Lista de acotres en generador >>>>> " + listaActores.size());
            //JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listaActores);

            JRDataSource dataSource = new ActorDataSource();
            JasperPrint reporteLleno = JasperFillManager.fillReport(
                    REPORTE_SIMPLE_ACTORES,
                    new HashMap<>(),
                    dataSource);

            return reporteLleno;

        } catch (JRException ex) {
            Logger.getLogger(ReportGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}

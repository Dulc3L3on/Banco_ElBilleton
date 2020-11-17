/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Entidades.Cambio;
import Modelo.Entidades.Usuarios.Cliente;
import Modelo.Manejadores.DB.BuscadorParaReportes;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.HttpHeaders;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author phily
 */
@WebServlet("/gestorExportacionHistorial")
public class GestorExportacionHistorialCompleto extends HttpServlet{
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response){
        BuscadorParaReportes buscador = new BuscadorParaReportes();
        Cliente clienteAntiguo = (Cliente)request.getSession().getAttribute("clienteAntiguo");
        try {

            if (request.getSession().getAttribute("codigo") == null) {
                response.sendRedirect(request.getContextPath() + "/Login_Usuario.jsp");//el context, es para obtener la dirección raiz, es decir la que tiene solo el nombre del proyecto y el servidor... [o cviceversa mejor dicho xD]
            }
            response.setContentType("application/pdf");
            response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=HistorialCambios.pdf");
            
            List<Cambio> listadoCambios = buscador.buscarHistorialDeCambios(clienteAntiguo.darCodigo());            

            File file = new File(request.getServletContext().getRealPath("/resources/Historial.jrxml"));
            JasperReport jasperReports = JasperCompileManager.compileReport(file.getAbsolutePath());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(listadoCambios);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("nombreUsuario", clienteAntiguo.darNombre());
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReports, parameters, dataSource);
            JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());

            response.getOutputStream().flush();
            response.getOutputStream().close();
            
        } catch (IOException | NumberFormatException   e) {
            System.out.println("Error en el gestor Historial de cambios: " + e.getMessage());

        } catch (JRException e) {
            System.out.println("Error al procesar el HISTORIAL de cambios COMPLETO: "+ e.getMessage());
        }
    }
    
    
}

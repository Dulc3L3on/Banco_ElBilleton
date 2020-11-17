/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
import java.io.InputStream;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author phily
 */

@WebServlet("/cargaDPI")//puesto que 2 páginas diferentes no pueden mandar su form a un mismo servlet... está comprobado xD
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class GestorCargaDPI extends HttpServlet{
    
    public static final String BASE_PATH = "/home/phily/Documentos/Carpeta_estudios/CuartoSemestre/IPC2/LabIPC2/Proyectos/ProyectoFinal/Proyecto/Banco_ElBilleton/BancoElBilleton/src/main/webapp/Trabajadores/Gerente/DPIs_ElBilleton";//entonces lo guardará en la carpeta del gerente...
        
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Processing file");                      
        Part filePart = request.getPart("archDPI");
        String fileName = getFileName(filePart); //no es necesario revisar si es null, porque es obligatorio el campo [required]       
        
        String path = BASE_PATH + "/" + fileName;
        filePart.write(path);
        
        String mimeType = filePart.getContentType();
        System.out.println("type: " + mimeType);
        System.out.println("file name: " + fileName);
        System.out.println("Stored at: " + path);        
        
        request.setAttribute("nombreArchDPI", fileName);
        request.getRequestDispatcher("gestorCreacionCliente").forward(request, response);
    }

    private String getFileName(final Part part) {        
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    
}// <object data="<%=herramienta.darPathDPI(cliente.darPath())%>"></object> basta con 1 ifram, 1 object o 1 embebed [este último si no lo probé xD, bueno sí pero no apareció nada xD  <!--<embed src="<%=cliente.darPath()%>" type="application/pdf" width="150px" height="150px"></embed>-->

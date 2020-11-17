/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import java.io.IOException;
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
@WebServlet("/gestorRecargaDPI")//puesto que 2 páginas diferentes no pueden mandar su form a un mismo servlet... está comprobado xD
@MultipartConfig(location="/tmp", fileSizeThreshold=1024*1024, 
    maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
public class GestorRecargaDPI extends HttpServlet{
    public static final String BASE_PATH = "/home/phily/Documentos/Carpeta_estudios/CuartoSemestre/IPC2/LabIPC2/Proyectos/ProyectoFinal/Proyecto/Banco_ElBilleton/BancoElBilleton/src/main/webapp/Trabajadores/Gerente/DPIs_ElBilleton";//puedes usarlo xD, solo pregunta cómo ceder permisos para que puedan cargarse archivos relativos a la raíz del proyecto...
        
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Processing file");
        String fileName=null;   
        String[] datosCliente = request.getParameterValues("datosActualizar");
        String nuevosDatosCLiente[] = new String[4];
        System.out.println(request.getParameter("pathAntiguo"));
        
        if(request.getPart("archDPI")!=null){//quiere decir que seleccionaron un arch... o eso compribarems xd, es que supongo que solo con saber que tiene un valor basta...
            Part filePart = request.getPart("archDPI");//mmmm bueno,es prueba xD
            fileName = getFileName(filePart);        
        
            String path = BASE_PATH + "/" + fileName;
            filePart.write(path);
        
            String mimeType = filePart.getContentType();
            System.out.println("type: " + mimeType);
            System.out.println("file name: " + fileName);
            System.out.println("Stored at: " + path);            
        }else{
            fileName = request.getParameter("pathAntiguo");
        }    
        
        nuevosDatosCLiente[0] = datosCliente[0];
        nuevosDatosCLiente[1] = fileName;
        nuevosDatosCLiente[2] = datosCliente[1];
        nuevosDatosCLiente[3] = datosCliente[2];        
       
        request.setAttribute("datosClienteNuevo", nuevosDatosCLiente);
        request.getRequestDispatcher("gestorModificacionCliente").forward(request, response);
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
    
}

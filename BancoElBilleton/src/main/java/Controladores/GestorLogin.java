/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Manejadores.Web.ManejadorNavegacion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phily
 */
@WebServlet("/gestorLogin")
public class GestorLogin extends HttpServlet{
   ManejadorNavegacion navegador = new ManejadorNavegacion();
    
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String pagina = navegador.darPaginasPrincipales(request.getParameter("tipoUsuario"));
        
        response.sendRedirect(pagina);        
    }
}
/*1. se revisa la corresp de datos
  2. se redirecciona
    2.1 se crea el objeto por medio de la recuperación de los datos [al redireccionar al doGet del gestor perfil
    2.2 se muestra la página
*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Entidades.Usuarios.Usuario;
import Modelo.Herramientas.GuardiaSeguridad;
import Modelo.Manejadores.DB.Buscador;
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
   Buscador buscador = new Buscador();
   Usuario usuario;
   GuardiaSeguridad guardia = new GuardiaSeguridad();
   ManejadorNavegacion navegador = new ManejadorNavegacion();//Se dará según el tipo de usuario
    
        
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)//UNa pregunta, cada vez que se redirecciona al servlet sucede lo mismo que cuando se llama a un método, es decir todo regresa a la normalidad?... sería de probar xD
    throws ServletException, IOException {                     
        String tipoUsuario = request.getParameter("tipoUsuario");
        
        System.out.println("codigo-> "+ request.getParameter("username"));
        if(!guardia.esUsuarioAutentico(request.getParameter("username"), request.getParameter("password"), tipoUsuario)){
           request.getSession().setAttribute("mostrarErrorLog", true);//si se entra aquí es porque hubo un error y por ello se redirigirá a la página de LOGIN...                       
           tipoUsuario = null;//para que se muestre el error...
        }else{
           request.getSession().setAttribute("codigo", request.getParameter("username"));//la contraseña no porque el gerente puede modificar la suya en la sesión en cuestión...            
        }
        System.out.println("sesión login-> "+request.getSession());
        System.out.println("codigo-> "+ request.getSession().getAttribute("codigo"));
        String pagina = navegador.darPaginasPrincipales(tipoUsuario);        
        response.sendRedirect(pagina);                   
    }    
    
}
/*1. se revisa la corresp de datos
  2. se redirecciona
    2.1 se crea el objeto por medio de la recuperación de los datos [al redireccionar al doGet del gestor perfil
    2.2 se muestra la página
*/
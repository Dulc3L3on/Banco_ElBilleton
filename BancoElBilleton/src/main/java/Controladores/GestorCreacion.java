/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Entidades.Cajero;
import Modelo.Entidades.Cliente;
import Modelo.Entidades.Usuario;
import Modelo.Manejadores.DB.Buscador;
import Modelo.Manejadores.DB.Creador;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author phily
 */
@WebServlet("/gestorCreacion")
public class GestorCreacion extends HttpServlet{
    Creador creador = new Creador();
    Cliente cliente;//iba a acrear la clase par atransportar los datos, de tal forma que fuera universoal, pero cliente, cajero y gerente, solo serían empleados para la sesión... y yo creo que eso no es correcto xD... además creo que tendría que codificar más xD...
    Cajero cajero;
    Buscador buscador = new Buscador();
    Usuario usuario;
 
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){                                                                           
        //aqupi verificas si está en sesión...        
        
        switch (request.getParameter("submit")) {
            case "CREAR CAJERO":                
                usuario = creador.crearCajero(request.getParameterValues("datosUsuario"));                
                cajero = (Cajero) usuario;
                request.setAttribute("turno", cajero.darTipoTurno());
            break;
            case "CREAR CLIENTE":                              
                usuario = creador.crearCajero(request.getParameterValues("datosUsuario"));
                cliente = (Cliente) usuario;
                request.setAttribute("birth", cliente.darBirth());
            break;                        
            default:
                usuario = null;
            break;
        }                              
        redireccionarPaginaResultados(request, response);//también hubiera podido ser el doGet xd :v
    }        
    
    public void redireccionarPaginaResultados(HttpServletRequest request, HttpServletResponse response){
        try {
        
            if(usuario==null){
                request.setAttribute("mostrarError", true);//solo para ser más expllícita xD
                request.getRequestDispatcher("Trabajadores/Gerente/Creacion_Cajero.jsp").forward(request, response);//para no redireccionar a la otra pag solo par mostra eso xD, sino se puede, deplano que se tendrá que hacer así xD        
            }else{
           //RECUERDA!!!, cuando es setAttribute, se DEBE usar la nitación con {} sino no se podrán tomar como objetos... el getParamete todo lo toma como objetos y se emplea [o al  menos yo lo he usado xD cuando se obtiene los valorse de los componentes, como de un botón...
                request.setAttribute("usuario", usuario);//solo para ser más expllícita xD
                request.getRequestDispatcher("Trabajadores/Gerente/Resultado_Creacion.jsp").forward(request, response);//para no redireccionar a la otra pag solo par mostra eso xD, sino se puede, deplano que se tendrá que hacer así xD        
            }    
            
        } catch (ServletException | IOException e) {
            System.out.println("Error al mostrar resultado de creación: "+ e.getMessage());
        }           
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Entidades.Usuarios.Cajero;
import Modelo.Entidades.Cuenta;
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
@WebServlet("/gestorCreacionCuenta")
public class GestorCreacionCuenta extends HttpServlet{
    Creador creador = new Creador();    
    Cuenta cuenta;//iba a acrear la clase par atransportar los datos, de tal forma que fuera universoal, pero cliente, cajero y gerente, solo serían empleados para la sesión... y yo creo que eso no es correcto xD... además creo que tendría que codificar más xD...
    Buscador buscador = new Buscador();    
 
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){                                                                           
        cuenta=null;            
        
        try {
            //aquI verificas si está en sesión...    NOP,debe se antes xD, es decir al presionar el botón crear... peor si quieres tb aquí por si las moscas xD
            
            cuenta = creador.crearCuentaCompleta(request.getParameterValues("datosCuenta"));
            if(cuenta!=null){
                request.setAttribute("mostrarMsje", "correcto");
            }else{
                request.setAttribute("mostrarMsje", "erroneo");
            }
            request.getRequestDispatcher("Trabajadores/Gerente/Creacion_Cuentas.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            System.out.println("Error al crear COMPLETAMENTE la CUENTA "+ ex.getMessage());
        }        
    }           
}

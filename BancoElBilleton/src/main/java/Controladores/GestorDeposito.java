/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Entidades.Transaccion;
import Modelo.Manejadores.DB.Tramitador;
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
@WebServlet("/gestorDeposito")
public class GestorDeposito extends HttpServlet{
    Tramitador tramitador = new Tramitador();
    Transaccion transaccion;   
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
         transaccion = tramitador.depositar( Integer.parseInt((String) request.getSession().getAttribute("codigo")), request.getParameter("numeroCuenta"), request.getParameter("monto"));//no se porque lo habrí anombrado opDeposito xd... le queda mejor monto xD
                 
        try {
            if(transaccion!=null){             
                request.setAttribute("transaccion", transaccion);
                request.getRequestDispatcher("Trabajadores/Cajero/Resultado.jsp").forward(request, response);             
            }else{
                request.setAttribute("mostrarError", true);
                request.getRequestDispatcher("Trabajadores/Cajero/Deposito.jsp").forward(request, response);             
            }            
        } catch (ServletException | IOException e) {
            System.out.println("Error al mostrar los resutados del DEPÓSITO: " + e.getMessage());
        }
    }       
}

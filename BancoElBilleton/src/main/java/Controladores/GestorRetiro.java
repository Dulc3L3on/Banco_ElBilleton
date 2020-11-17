/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelo.Entidades.Transaccion;
import Modelo.Manejadores.DB.Buscador;
import Modelo.Manejadores.DB.Registrador;
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
@WebServlet("/gestorRetiro")
public class GestorRetiro extends HttpServlet{
    Tramitador tramitador = new Tramitador();    
    Transaccion transaccion;   
    Registrador registrador = new Registrador();
    Buscador buscador = new Buscador();
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        int saldoActual = -1;//para que si se llega al final de bloque y se obtiene este valor, es un hecho de que más de algo falló xD, lo cual es lo único que le interesa saber al cajero...        
       
        if(tramitador.retirar(request.getParameter("numeroCuenta"), request.getParameter("monto"))){//no se porque lo habrí anombrado opDeposito xd... le queda mejor monto xD
            transaccion = registrador.registrarTrasaccion(Integer.parseInt(request.getSession().getAttribute("codigo").toString()),
                  request.getParameter("numeroCuenta"), request.getParameter("monto"), "debito");         
         
            if(transaccion!=null){     
                saldoActual = buscador.buscarSaldoActual(request.getParameter("numeroCuenta"));
                    
                if(saldoActual!=-1){//pues si puede quedar en 0 el saldo, pero no menos de eso...por ello si es -1, el porceso falló...
                    request.setAttribute("saldoActual", saldoActual);
                    request.setAttribute("tipo", "debito");
                    request.setAttribute("transaccion", transaccion);                
                }                    
            }                                     
        }     
        try { 
            if(saldoActual==-1){
                request.setAttribute("mostrarError", true);     
            }
            request.getRequestDispatcher("Trabajadores/Cajero/Resultado_Transaccion.jsp").forward(request, response);             
         } catch (ServletException | IOException e) {
                System.out.println("Error al mostrar los resutados del RETIRO: " + e.getMessage());
         }
    }       
    
    
}
